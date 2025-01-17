-- 코드를 입력하세요
select
    FH.FLAVOR
from
    FIRST_HALF FH
join
    ICECREAM_INFO II ON II.FLAVOR = FH.FLAVOR
where
    FH.TOTAL_ORDER > 3000
    AND II.INGREDIENT_TYPE = 'fruit_based'
order by
    TOTAL_ORDER DESC