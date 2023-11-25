INSERT IGNORE INTO seller(id, name, created_at, updated_at)
VALUES
    (null, '컬리', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at)
VALUES
    (null, '[전주 베테랑] 칼국수', 5000, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly1.png',
    20, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );