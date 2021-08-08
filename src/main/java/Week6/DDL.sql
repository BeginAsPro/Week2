CREATE TABLE customer (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增顾客ID',
    name VARCHAR(16) NOT NULL COMMENT '顾客姓名',
    identify_type TINYINT NOT NULL DEFAULT 1 COMMENT '证件类型: 1 身份证, 2 军官证, 3 护照',
    identify_num VARCHAR(32) COMMENT '证件号码',
    phone_num BIGINT UNSIGNED COMMENT '手机号',
    email VARCHAR(64) COMMENT '邮箱',
    gender CHAR(1) COMMENT '性别',
    created_time TIMESTAMP NOT NULL COMMENT '创建时间',
    modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY(id)
) ENGINE = innodb COMMENT '用户信息表';


##

CREATE TABLE product_info (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品ID',
    price DECIMAL(8,2) NOT NULL COMMENT '商品价格',
    name VARCHAR(64) NOT NULL COMMENT '商品名字',
    product_tag CHAR(16) NOT NULL COMMENT '商品条码',
    content VARCHAR(128) NOT NULL COMMENT '商品描述',
    created_time TIMESTAMP NOT NULL COMMENT '创建时间',
    modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY(id)
) ENGINE = innodb COMMENT '商品信息表';

##

CREATE TABLE order_msg (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    order_num BIGINT UNSIGNED NOT NULL COMMENT '订单编号 yyyymmddnnnnnnnn',
    customer_id INT UNSIGNED NOT NULL COMMENT '下单人ID',
    shipping_user VARCHAR(10) NOT NULL COMMENT '收货人姓名',
    province SMALLINT NOT NULL COMMENT '省',
    city SMALLINT NOT NULL COMMENT '市',
    district SMALLINT NOT NULL COMMENT '区',
    address VARCHAR(100) NOT NULL COMMENT '地址',
    payment_method TINYINT NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
    order_money DECIMAL(8,2) NOT NULL COMMENT '订单金额',
    district_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
    shipping_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '运费金额',
    payment_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '支付金额',
    shipping_comp_name VARCHAR(10) COMMENT '快递公司名称',
    shipping_sn VARCHAR(50) COMMENT '快递单号',
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
    shipping_time DATETIME COMMENT '发货时间',
    pay_time DATETIME COMMENT '支付时间',
    modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
) ENGINE = innodb COMMENT '订单信息表';