# seller
INSERT IGNORE INTO seller(id, name, created_at, updated_at)
VALUES
    (null, '컬리', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

# category
INSERT IGNORE INTO category(category_type) values('NOODLES');

# subcategory
INSERT IGNORE INTO sub_category(category_id, sub_category_type) values (1, 'PASTA_NOODLES');

# product
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[전주 베테랑] 칼국수', 5000, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly1.png',
    20, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[시골보쌈과 감자옹심이] 감자옹심이 칼국수(2인분)', 10500, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly1.png',
    0, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[올면] 속초식 명태 회냉면 2인분', 12000, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly3.svg',
    0, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[광화문 미진] 메밀국수 (2인분)', 9980, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly4.svg',
    7, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[이연복의 목란] 짬뽕 2인분 (맵기선택)', 13800, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly5.svg',
    5, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[하림] 춘천식 닭갈비 밀키트', 15900, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly6.svg',
    7, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[바른식] 강릉식 짬뽕 순두부', 8900, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly7.svg',
    10, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[김구원선생] 두부 된장찌개 밀키트', 6700, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly8.svg',
    0, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[이연복의 목란] 사천 짜장면 2인분', 12300, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly9.png',
    9, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
INSERT IGNORE INTO product(id, product_name, price, imageurl, discount_rate, delivery_type, seller_id, created_at, updated_at, category_id)
VALUES
    (null, '[도리깨침] 월남쌈 밀키트', 21200, 'https://insopt-seminar3.s3.ap-northeast-2.amazonaws.com/marketKurly/kurly10.svg',
    5, 'SAME_DAY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

