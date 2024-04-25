-- 코드를 입력하세요
SELECT
    c.CAR_TYPE,
    COUNT(*) AS CARS
FROM
    CAR_RENTAL_COMPANY_CAR c
    WHERE
        c.OPTIONS LIKE '%통풍시트%' or 
        c.OPTIONS LIKE '%열선시트%' or 
        c.OPTIONS LIKE '%가죽시트%'
    GROUP BY
        c.CAR_TYPE
ORDER BY
    c.CAR_TYPE