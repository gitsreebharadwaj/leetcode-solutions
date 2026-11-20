# Write your MySQL query statement below
SELECT m.name
FROM EMPLOYEE AS e
JOIN EMPLOYEE AS m
ON m.id=e.managerId
GROUP BY m.id
HAVING COUNT(e.id)>=5;
