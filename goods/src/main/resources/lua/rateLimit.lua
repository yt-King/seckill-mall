-- 通过hash结构记录限制额度信息
-- 支持： -1值不存在，0库存不足，>0成功后当前值
local sKey = KEYS[1]    -- hash的key值
local sKey2 = ARGV[1]   -- 哈希内的子健
local sNum = ARGV[2]    -- 需要的增加的额度
local sLimit = ARGV[3]  -- 限制的额度
local iNum = 1
if (sNum)
then
    iNum = tonumber(sNum)
end

-- 不存在字段的时候返回 -1
local iExists = redis.call("EXISTS", sKey)
if (iExists == 0)
then
    return -1;
end

local iLimit = tonumber(sLimit)
-- 查询已获取数量
local sCount = redis.call("hget", sKey, sKey2)

-- 判断库存是否足够
local iCount = tonumber(sCount)
if (iCount + iNum > iLimit)
then
    return 0;
end

-- 发起额度控制的命令
return redis.call("hincrby", sKey, sKey2, iNum);
