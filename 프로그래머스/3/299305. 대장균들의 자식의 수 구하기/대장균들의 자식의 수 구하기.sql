-- 코드를 작성해주세요
select ED.ID, COUNT(CHILD.ID) as CHILD_COUNT
from ECOLI_DATA ED
left join ECOLI_DATA as CHILD
    ON ED.ID = CHILD.PARENT_ID
group by ED.ID
order by ED.ID ASC