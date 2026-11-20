# Write your MySQL query statement below
SELECT DISTINCT p.product_id, p.product_name
FROM PRODUCT AS p
INNER JOIN SALES AS s1
ON p.product_id=s1.product_id
AND s1.sale_date BETWEEN '2019-01-01' AND '2019-03-31'
LEFT JOIN SALES AS s2
ON p.product_id=s2.product_id
AND(s2.sale_date<'2019-01-01' OR s2.sale_date>'2019-03-31')
WHERE s2.product_id IS NULL; 
