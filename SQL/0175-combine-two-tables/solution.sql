# Write your MySQL query statement below
SELECT p.firstName, p.lastName, a.city, a.state
FROM ADDRESS AS a
RIGHT JOIN PERSON AS p
ON a.personId=p.personId;
