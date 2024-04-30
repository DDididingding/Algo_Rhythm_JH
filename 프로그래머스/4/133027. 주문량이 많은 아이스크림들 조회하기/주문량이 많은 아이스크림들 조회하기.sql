SELECT
    f.FLAVOR
FROM
    (SELECT
        FLAVOR,
        SUM(TOTAL_ORDER) AS TOTAL
    FROM
        FIRST_HALF
    GROUP BY
        FLAVOR) f
JOIN
    (SELECT
        FLAVOR,
        SUM(TOTAL_ORDER) AS TOTAL
    FROM
        JULY
    GROUP BY
        FLAVOR) j
ON
    f.FLAVOR = j.FLAVOR
    
ORDER BY 
    f.TOTAL + j.TOTAL DESC
LIMIT
    3

