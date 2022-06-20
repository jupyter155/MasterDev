-- //// 1 Diem TB cua toan truong

SELECT
	AVG(mark)
FROM
	class_student
	
-- //// 2 Ti le truot, tb , kha , gioi , xuat xac
	
SELECT (SELECT COUNT(mark) FROM class_student WHERE mark<4)*100/(SELECTCOUNT(mark) FROM class_student ) AS TLT,
(SELECT COUNT(mark) FROM class_student WHERE mark>4 AND mark<6)*100/(SELECTCOUNT(mark) FROM class_student ) AS TLTB,
(SELECT COUNT(mark) FROM class_student WHERE mark>6 AND mark<8)*100/(SELECTCOUNT(mark) FROM class_student ) AS TLK,
(SELECT COUNT(mark) FROM class_student WHERE mark>8 AND mark<9)*100/(SELECTCOUNT(mark) FROM class_student ) AS TLG,
(SELECT COUNT(mark) FROM class_student WHERE mark>9)*100/(SELECT COUNT(mark)FROM class_student ) AS TLXS

-- //// 3 Mon co diem TB cao nhat

SELECT
	*
FROM
	(
	SELECT
		AVG(mark) AS avg_mark ,
		max_avg.idSubject
	FROM
		(
		SELECT
			mark,
			s.idSubject
		FROM
			class_student cs
		INNER JOIN subject s
ON
			cs.idSubject = s.idSubject
) AS max_avg
	GROUP BY
		idSubject ) AS max_avg1
ORDER BY
	avg_mark DESC
LIMIT 1

-- //// 4 Lop co diem TB cao nhat
 
SELECT
	*
FROM
	(
	SELECT
		AVG(mark) AS avg_mark ,
		max_avg.idClass
	FROM
		(
		SELECT
			mark,
			cs.idClass
		FROM
			class_student cs
		INNER JOIN class c
ON
			cs.idClass = c.idClass) AS max_avg
	GROUP BY
		idClass ) AS max_avg1
ORDER BY
	avg_mark DESC
LIMIT 1

-- //// 5 Ban co diem trung binh cao nhat

SELECT
	*
FROM
	(
	SELECT
		AVG(mark) AS avg_mark ,
		max_avg.nameStudent
	FROM
		(
		SELECT
			mark,
			cs.idStudent,
			s.nameStudent
		FROM
			class_student cs
		INNER JOIN student s
ON
			cs.idStudent = s.idStudent
) AS max_avg
	GROUP BY
		idStudent ) AS max_avg1
ORDER BY
	avg_mark DESC
LIMIT 1

-- //// 6 Mon co ti truot cao nhat 

SELECT
	*
FROM
	(
	SELECT
		nameSubject,
		ratio_fail
	FROM
		(
		SELECT
			p.idSubject ,
			count_fail_mark * 100 / COUNT(mark) AS ratio_fail
		FROM
			(
			SELECT
				idSubject ,
				COUNT(fail_mark) AS count_fail_mark
			FROM
				(
				SELECT
					idSubject,
					mark AS fail_mark
				FROM
					class_studentWHERE
mark < 4) AS fail_mark_lst
			GROUP BY
				fail_mark_lst.idSubject) p
		INNER JOIN class_student
ON
			ON
			p.idSubject = class_student.idSubject
		GROUP BY
			idSubject) m
	INNER JOIN subject s
m.idSubject = s.idSubject) AS b6
ORDER BY
	ratio_fail DESC
LIMIT 1

-- 7 Danh sach cac ban khong truot mon nao 

SELECT
	cs.mark ,
	s.nameStudent
FROM
	class_student cs
INNER JOIN student s
ON
	cs.idStudent = s.idStudent
WHERE
	mark > 4
	
-- //// 8  TOp 10  mon hoc kho nhat 
	
SELECT
	cs.mark ,
	s.nameSubject
FROM
	class_student cs
INNER JOIN subject s
ON
	cs.idSubject = s.idSubject
GROUP BY
	s.nameSubject
ORDER BY
	cs.mark DESC
LIMIT 10