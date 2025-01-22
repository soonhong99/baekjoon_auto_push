-- 코드를 입력하세요
select
    COUNT(*) as USERS
from
    USER_INFO
where
    YEAR(JOINED) = 2021
    AND AGE >= 20
    AND AGE <= 29
