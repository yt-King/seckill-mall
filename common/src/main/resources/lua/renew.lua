-- 给缓存key续期
-- -1=key不存在，0=不需要续期，1=续期成功
local sKey = KEYS[1]  -- 健值
local iSecond = ARGV[1]  -- 续期时间(秒)
if (iSecond)
then
    iSecond = tonumber(iSecond)
end

-- 判断key存不存在
-- 不存在字段的时候返回 -1
local iExists = redis.call("exists", sKey)
if (iExists == 0)
then
    return -1;
end

-- 判断key的有效期是否小于120秒 是的话续期
local iTTl = redis.call('ttl', sKey)
 if (iTTl < 120)
 then
    return redis.call('expire', sKey, iSecond);
 end

 return 0;


