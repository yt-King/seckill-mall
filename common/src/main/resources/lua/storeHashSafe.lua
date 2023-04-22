-- 提供并发安全的数据存储功能 hash类型
local sKey = KEYS[1] -- 健值
local iSecond = ARGV[1] -- 过期时间(秒)

if (iSecond)
then
    iSecond = tonumber(iSecond)
end
--
---- 判断key存不存在
---- 存在字段的时候直接返回
local iExists = redis.call("exists", sKey)
if (iExists == 1)
then
    return 0;
end

table.remove(ARGV, 1)
redis.call("hmset", sKey, unpack(ARGV))
return redis.call("expire", sKey, iSecond)