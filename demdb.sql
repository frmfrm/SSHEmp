##创建数据库
CREATE DATABASE empdb;
##打开数据库
USE empdb;

##创建部门表
CREATE TABLE dep(
  depid INT PRIMARY KEY AUTO_INCREMENT,##主键自增
  depname VARCHAR(50) NOT NULL
);

##创建福利表
CREATE TABLE welfare(
  wid INT PRIMARY KEY AUTO_INCREMENT,
  wname VARCHAR(50) NOT NULL
);

##创建员工表，和部门之间是多对一关系,部门的子表
CREATE TABLE emp(
  eid INT PRIMARY KEY AUTO_INCREMENT,
  ename VARCHAR(50) NOT NULL,
  sex VARCHAR(4) DEFAULT '男',
  address VARCHAR(100),
  birthday DATE,
  photo VARCHAR(50),
  depid INT NOT NULL,
  CONSTRAINT fk_depid FOREIGN KEY (depid) REFERENCES dep(depid)    
);

##员工薪资表(与员工一对一关系)
CREATE TABLE salary(
  sid INT PRIMARY KEY AUTO_INCREMENT,
  eid INT NOT NULL UNIQUE,
  emoney FLOAT CHECK (emoney>=2000),
  CONSTRAINT fk_saleid FOREIGN KEY (eid) REFERENCES emp(eid)    
);

##员工福利关系表（员工与福利表的关系表(多对多关系)）
CREATE TABLE empwelfare(
  ewid INT PRIMARY KEY AUTO_INCREMENT,
  eid INT NOT NULL,
  wid INT NOT NULL,
  CONSTRAINT fk_eweid FOREIGN KEY (eid) REFERENCES emp(eid),
  CONSTRAINT fk_ewwid FOREIGN KEY (wid) REFERENCES welfare(wid)  
);
CREATE TABLE users(
	aid INT PRIMARY KEY AUTO_INCREMENT,
	aname VARCHAR(50),
	passwd VARCHAR(50)
);
INSERT INTO users(aname,passwd) VALUES('admin','admin');
 
##插入初始化数据
##部门数据
INSERT INTO dep(depname) VALUES('技术部'); 
INSERT INTO dep(depname) VALUES('财务部');
INSERT INTO dep(depname) VALUES('市场部');
INSERT INTO dep(depname) VALUES('运维部');
INSERT INTO dep(depname) VALUES('行政部');
INSERT INTO dep(depname) VALUES('人事部');
SELECT * FROM dep;

##插入福利数据
INSERT INTO welfare(wname) VALUES('误餐费');
INSERT INTO welfare(wname) VALUES('取暖费');
INSERT INTO welfare(wname) VALUES('降温费');
INSERT INTO welfare(wname) VALUES('差旅费');
INSERT INTO welfare(wname) VALUES('交通费');
INSERT INTO welfare(wname) VALUES('五险一金');
SELECT * FROM welfare;


SELECT w.* FROM empwelfare ewf,welfare w WHERE ewf.wid=w.wid AND ewf.eid=1

/**
创建视图
*/
CREATE VIEW vwemp
AS
SELECT e.*,d.depname FROM emp e,dep d WHERE e.depid=d.depid;

SELECT * FROM vwemp;
SELECT * FROM salary;
SELECT * FROM empwelfare;
SELECT * FROM vwemp WHERE 1=1 ORDER BY eid LIMIT 0,5;