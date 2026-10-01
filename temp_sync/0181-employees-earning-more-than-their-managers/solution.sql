# Write your MySQL query statement below
SELECT e.name AS Employee
FROM EMPLOYEE AS e
JOIN EMPLOYEE AS m
ON m.id=e.managerId
WHERE e.salary>m.salary;
