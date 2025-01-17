select
    MEMBER_ID,
    MEMBER_NAME,
    GENDER,
    DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from
    member_profile
where
    month(date_of_birth) = 3
    AND TLNO IS NOT NULL
    AND GENDER = 'W'
order by
    MEMBER_ID ASC