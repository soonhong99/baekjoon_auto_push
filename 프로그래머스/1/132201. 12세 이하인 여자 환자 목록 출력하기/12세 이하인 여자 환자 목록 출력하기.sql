-- 코드를 입력하세요
select
    PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    IFNULL(TLNO, 'NONE') as TLNO
from
    PATIENT
where
    GEND_CD = 'W'
    AND AGE <= 12
order by
    AGE DESC,
    PT_NAME ASC