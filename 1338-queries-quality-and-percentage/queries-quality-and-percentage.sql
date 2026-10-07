# Write your MySQL query statement below
SELECT DISTINCT query_name , ROUND(AVG(q.rating/q.position),2) as quality , ROUND(SUM(rating<3) * 100 /COUNT(rating),2) as poor_query_percentage
FROM Queries q
GROUP BY  query_name