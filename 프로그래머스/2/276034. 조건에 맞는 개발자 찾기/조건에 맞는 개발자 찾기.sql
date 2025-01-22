-- 코드를 작성해주세요
select
    D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
from
    DEVELOPERS D
join 
    SKILLCODES S ON (S.CODE & D.SKILL_CODE) = S.CODE
where
    S.NAME = 'C#'
    OR S.NAME = 'Python'
group by
    D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
order by
    D.ID ASC
    