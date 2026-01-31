-- 핵심 테이블: User 및 Orders 예시
CREATE TABLE users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       name VARCHAR(100)
);
CREATE TABLE orders (
                        order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        user_id BIGINT,
                        order_date DATETIME,
                        status VARCHAR(50),
                        FOREIGN KEY (user_id) REFERENCES users(user_id)
);