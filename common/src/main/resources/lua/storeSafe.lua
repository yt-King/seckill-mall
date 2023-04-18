-- 提供并发安全的数据存储功能 string类型
local sKey = KEYS[1] -- 健值
local iSecond = ARGV[2] -- 过期时间(秒)
if (iSecond)
then
    iSecond = tonumber(iSecond)
end

-- 判断key存不存在
-- 存在字段的时候直接返回
local iExists = redis.call("exists", sKey)
if (iExists == 1)
then
    return 0;
end
-- ARGV[1] 是值
local t = redis.call('set', sKey, ARGV[1], 'EX', iSecond)
for k, v in pairs(t) do
    if (v == 'OK')
    then
        return 1
    end
end
return 0;