-- 负责提供并发安全的数据存储功能
local sKey = KEYS[1]    -- 健值
local iUpdate = tonumber(ARGV[1]) -- 是否是更新操作
local iExists = redis.call("EXISTS",sKey)
-- 更新操作要求数据存在，插入操作要求数据不存在
if(iExists ~= iUpdate)
then
    return 0;
end

table.remove(ARGV,1)
return redis.call("hmset",sKey,unpack(ARGV));
