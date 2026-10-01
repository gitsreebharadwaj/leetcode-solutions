# Write your MySQL query statement below
SELECT d.name AS DEPARTMENT, e.name AS EMPLOYEE, e.salary AS SALARY
FROM EMPLOYEE AS e
JOIN DEPARTMENT AS d
ON e.departmentId=d.id
WHERE
(e.departmentId, e.salary) IN (
    SELECT departmentId, MAX(salary)
    FROM EMPLOYEE
    GROUP BY departmentId
);
