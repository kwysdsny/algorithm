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

-- from
-- on
-- join
-- where
-- group by
-- min max avg count sum
-- having
-- select
-- distinct
-- order by
-- limit
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



select a.user_id, ROUND(IFNULL(AVG(b.action = 'confirmed'), 0), 2) AS confirmation_rate
from signups as a
         left join confirmations as b on a.user_id = b.user_id
group by a.user_id


--rating<3返回布尔值，求数量应该用sum(rating<3)，使用count则统计所有数量等价count(*)
select query_name,
       round(avg(rating / position), 2)           quality,
       round(sum(rating < 3) * 100 / count(*), 2) poor_query_percentage
from queries
group by query_name


SELECT ROUND(
               COUNT(1) /
               (SELECT COUNT(DISTINCT player_id) FROM activity),
               2
       ) AS fraction
FROM activity a
         JOIN activity b
              ON a.player_id = b.player_id
WHERE DATEDIFF(b.event_date, a.event_date) = 1
  AND a.event_date = (SELECT MIN(event_date)
                      FROM activity
                      WHERE player_id = a.player_id);


-- 最小值和最大值在某个期间日期内
select a.product_id, b.product_name
from Sales a
         join Product b
              on a.product_id = b.product_id
group by a.product_id
having min(sale_date) >= '2019-01-01'
   and max(sale_date) <= '2019-03-31'


-- having
select class
from courses
group by class
having count(student) >= 5


--https://leetcode.cn/problems/biggest-single-number/?envType=study-plan-v2&envId=sql-free-50
SELECT MAX(num) AS num
FROM (SELECT num
      FROM mynumbers
      GROUP BY num
      HAVING COUNT(num) = 1) AS t

-- 一些题目可以去使用having语句
SELECT customer_id
FROM Customer
WHERE product_key IN (SELECT product_key FROM Product)
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);

-- 使用union
SELECT employee_id,
       department_id
FROM Employee
GROUP BY employee_id
HAVING COUNT(department_id) = 1
UNION
SELECT employee_id,
       department_id
FROM Employee
WHERE primary_flag = 'Y';

-- 上面的和下面的同一题
-- 使用or 子查询
SELECT e.employee_id, department_id
FROM Employee e
WHERE e.primary_flag = 'Y'
   OR e.employee_id in
      (SELECT employee_id
       FROM Employee
       GROUP BY employee_id
       HAVING COUNT(employee_id) = 1);


--思路：先查询出所有的product_id，然后左连接查询出每个product_id的最新价格，如果没有最新价格则默认10，套娃总能写出来
select p1.product_id, ifnull(p2.new_price, 10) price
from (select distinct product_id
      from products) p1
         left join
     (select product_id, new_price
      from products
      where (product_id, change_date) in
            (select product_id, max(change_date)
             from products
             where change_date <= '2019-08-16'
             group by product_id)) p2 on p1.product_id = p2.product_id















