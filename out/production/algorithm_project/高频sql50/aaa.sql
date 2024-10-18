-- <>表示不等于（！=）
SELECT name
FROM customer
WHERE referee_id <> 2
   OR referee_id IS NULL;


-- distinct 去重      as 取别名    order by author_id  desc降序
select distinct author_id as id
from views
where author_id = viewer_id
order by author_id



-- 1、char_length(str)
-- （1）计算单位：字符
-- （2）不管汉字还是数字或者是字母都算是一个字符
-- 2、length(str)
-- （1）计算单位：字节
-- （2）utf8编码：一个汉字三个字节，一个数字或字母一个字节。
-- （3）gbk编码：一个汉字两个字节，一个数字或字母一个字节。
select tweet_id
from tweets
where char_length(content) > 15


-- 左连接id 空值自动补null left join ... on ...
select unique_id, name
from Employees
         left join EmployeeUNI on Employees.id = EmployeeUNI.id


-- 左连接找null根据customer_id分组统计数量
-- 已经根据customer_id分组可使用COUNT(*) 或者COUNT(1)
-- COUNT(1) 和 COUNT(*) 在功能上是等价的。两者都会返回符合条件的行数，但 COUNT(*) 会更快一些，因为它不需要评估任何表达式。总的来说，两者都可以用于统计记录的数量。
select customer_id, count(customer_id) as count_no_trans
from Visits v
         left join Transactions t on v.visit_id = t.visit_id
where transaction_id is null
group by customer_id

--datediff(a,b) a日期大于b日期返回大于的天数（可为负数） 使用自连接查询条件 多条件使用join了尽量不使用where
select a.id
from weather a
         join weather b on a.temperature > b.temperature and datediff(a.recordDate, b.recordDate) = 1



-- 执行顺序
-- FROM：确定数据源，从哪个表中提取数据。
-- JOIN：如果有多个表，执行连接操作。
-- WHERE：过滤数据，只保留满足条件的行。
-- GROUP BY：对结果进行分组。
-- HAVING：对分组后的数据进行过滤。
-- SELECT：选择需要的列或计算字段。
-- ORDER BY：对结果集进行排序。
-- LIMIT/OFFSET：限制返回的结果数量。
select a.machine_id, ROUND(AVG(a.timestamp - b.timestamp), 3) AS processing_time
FROM Activity a
         JOIN Activity b
              on
                  a.machine_id = b.machine_id and
                  a.process_id = b.process_id and a.activity_type = "end" and b.activity_type = "start"
group by a.machine_id


-- 进行连接时是对两表进行匹配，不能使用查询条件，例如b.bonus<1000，可以使用a.temperature>b.temperature
--简单说就是连接时的条件需要用两到两表，不能写只用一张表的连接条件
--isnull(bonus)等于bonus is null
select name, bonus
from Employee e
         left join bonus b on e.empid = b.empid
where b.bonus < 1000
   or isnull(bonus)


---cross join 两表相乘  
select Students.student_id, student_name, Subjects.subject_name, count(E.student_id) attended_exams
from (Students , Subjects)
         left join Examinations E on E.subject_name = Subjects.subject_name and E.student_id = Students.student_id
group by student_id, subject_name
order by student_id, subject_name;














