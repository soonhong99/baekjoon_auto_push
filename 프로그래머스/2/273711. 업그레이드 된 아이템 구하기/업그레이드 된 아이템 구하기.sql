select
    II.ITEM_ID, II.ITEM_NAME, II.RARITY
from
    ITEM_INFO II
join
    ITEM_TREE IT ON IT.ITEM_ID = II.ITEM_ID
join
    ITEM_INFO PARENT ON PARENT.ITEM_ID = IT.PARENT_ITEM_ID
where
    PARENT.RARITY = 'RARE'
order by
    II.ITEM_ID DESC
