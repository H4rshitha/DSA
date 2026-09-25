# Write your MySQL query statement below
SELECT  p.product_name,sa.year,sa.price
FROM Sales sa
JOIN Product p ON sa.product_id = p.product_id 