create grain pView version '1.0';


CREATE table t1 (
  id INT NOT NULL IDENTITY PRIMARY KEY,
  f1 int,
  f2 int,
  f3 VARCHAR (2)
);

CREATE FUNCTION pView1(p int) AS
  select sum (f1) as sumv, f3 as f3
  from t1 as t1
  where f2 = $p
  group by f3;

CREATE FUNCTION pView2(p1 int,/**TEST*/ p2 varchar) AS
  select f1, f2, f3 from t1
  where f2 = $p1 AND f3 = $p2;