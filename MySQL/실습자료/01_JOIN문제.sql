
-- 데이터베이스 접속
USE MYTEST;

SELECT * FROM emp; -- 사원정보
SELECT * FROM dept; -- 부서정보
SELECT * FROM salgrade; -- 급여등급


create view test as (
	select * from emp e join dept d using(deptno)
);
-- 1. SMITH 에 대한  정보 검색(ename, emp.deptno, loc .)
select ename, e.deptno, loc from emp e join dept d on (e.DEPTNO = d.DEPTNO) and ename = 'smith';
/* 2. NEW YORK에 근무하는 사원의 이름과 급여를 출력 - 서브쿼리로도 가능하다.
 먼저 dept테이블에서 NEW YORK의 부서번호를 구한다. 그 구한 부서번호를 부서번호로 사용하고 있는 사원의 정보를 검색한다.
*/
select ename, sal from emp e join dept d using (deptno) where loc = 'new york';

select ename, sal from emp where deptno in (select deptno from dept where loc = 'new york');

-- 3. ACCOUNTING 부서 소속 사원의 이름과 입사일 출력 - 서브쿼리 가능

select ename, hiredate from test where dname = 'accounting';
-- 4. 직급이 MANAGER인 사원의 이름, 부서명 출력
select * from test;
select ename, dname from test where job = 'manager';
-- 5. 사원의 급여가 몇 등급인지를 검색
-- between A and B
select ename, grade from emp e join salgrade s on sal between losal and hisal;

-- 6. 사원 테이블의 부서 번호로 부서 테이블을 참조해서 부서명, 급여 등급도 검색
select ename, dname, grade from emp e join dept d using(deptno) join salgrade on sal between losal and hisal;

SELECT * FROM emp;
SELECT * FROM dept; -- 부서정보
SELECT * FROM salgrade; -- 급여등급


-- 7. SMITH의 메니저(mgr) 이름(ename) 검색
 -- 'SMITH의 관리자는 ~ 입니다.'  - CONCAT함수 이용
select concat(a.ename, '의 관리자는 ', b.ename, ' 입니다') from emp a join emp b on (a.mgr = b.EMPNO);
  
-- 8. 관리자가 KING인 사원들의 이름과 직급(job) 검색
select a.ename, a.job, a.mgr, b.empno, b.ename from emp a join emp b on (a.mgr = b.EMPNO) where b.ename = 'king';
  
-- 9. SMITH 와 동일한 부서번호(DEPTNO)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터 출력 불가
select b.ename from emp a join emp b on(a.deptno = b.deptno and a.ename = 'smith' and b.ename <> 'smith');

-- 10. SMITH 와 동일한 근무지(LOC)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터  출력 불가
select b.ename, d.loc from emp a join emp b on(a.deptno = b.deptno and a.ename = 'smith' and b.ename <> 'smith') join dept d on(b.deptno = d.deptno);
select * from dept;
-- 11, 사원명, 해당 하는 메니저명 검색
-- 반드시 모든 사원들(CEO포함) 정보 검색
-- CEO인 경우 메니저 정보 null
select a.ename, b.ename from emp a left join emp b on(a.mgr = b.empno);




  

  
  
  
  
  







