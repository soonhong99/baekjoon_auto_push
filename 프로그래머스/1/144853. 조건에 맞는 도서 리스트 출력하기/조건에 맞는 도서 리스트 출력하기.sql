-- 코드를 입력하세요
select
    BOOK_ID,
    DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from
    BOOK
where
    YEAR(PUBLISHED_DATE) = 2021
    AND CATEGORY = '인문'
order by
    PUBLISHED_DATE ASC
