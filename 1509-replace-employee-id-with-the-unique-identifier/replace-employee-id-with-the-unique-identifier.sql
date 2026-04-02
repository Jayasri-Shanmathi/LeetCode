# Write your MySQL query statement below
Select EU.unique_id,E.name from Employees  E left join EmployeeUNI EU on E.id=EU.id; 