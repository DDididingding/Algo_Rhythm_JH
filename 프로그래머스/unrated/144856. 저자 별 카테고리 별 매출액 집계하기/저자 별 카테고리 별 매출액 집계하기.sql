-- 코드를 입력하세요
SELECT
    A.AUTHOR_ID,
    A.AUTHOR_NAME,
    B.CATEGORY,
    SUM(S.SALES*B.PRICE) AS TOTAL_SALES
FROM
    BOOK_SALES S
JOIN
    BOOK B
ON
    S.BOOK_ID = B.BOOK_ID
JOIN
    AUTHOR A
ON
    B.AUTHOR_ID = A.AUTHOR_ID

WHERE
    S.SALES_DATE LIKE '2022-01%'
GROUP BY
    A.AUTHOR_ID,
    A.AUTHOR_NAME,
    B.CATEGORY
ORDER BY
    A.AUTHOR_ID ASC,
    B.CATEGORY DESC;
