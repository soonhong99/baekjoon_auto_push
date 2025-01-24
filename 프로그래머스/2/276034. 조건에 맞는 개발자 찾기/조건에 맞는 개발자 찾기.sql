-- 코드를 작성해주세요
select distinct
    D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
from
    DEVELOPERS D
join
    SKILLCODES S ON S.CODE & D.SKILL_CODE = S.CODE
where
    S.NAME = 'Python'
    OR S.NAME = 'C#'
order by
    D.ID ASC
    