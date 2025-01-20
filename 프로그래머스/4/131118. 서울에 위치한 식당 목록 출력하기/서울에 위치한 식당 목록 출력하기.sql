-- 코드를 입력하세요
select
    RI.REST_ID,
    RI.REST_NAME,
    RI.FOOD_TYPE,
    RI.FAVORITES,
    RI.ADDRESS,
    ROUND(AVG(RR.REVIEW_SCORE), 2) as SCORE
from
    REST_INFO RI
join
    REST_REVIEW RR ON RR.REST_ID = RI.REST_ID
where
    SUBSTRING(RI.ADDRESS, 1, 2) = '서울'
group by
    RI.REST_ID
order by
    SCORE DESC,
    RI.FAVORITES DESC
# where