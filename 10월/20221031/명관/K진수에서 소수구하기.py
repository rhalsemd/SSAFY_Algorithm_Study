def to_k_number(n, k):
    ret = ""
    while n > 0:
        ret += str(n % k)
        n = n // k
    return ''.join(reversed(ret))


def is_prime_num(k):
    if k == 2 or k == 3: return True
    if k % 2 == 0 or k < 2: return False
    for i in range(3, int(k ** 0.5) + 1, 2):
        if k % i == 0:
            return False
    return True


def solution(n, k):
    answer = 0
    k_num = to_k_number(n, k)  # k진수로 반환
    # k_num을 0을 기준으로 분할하여 n을 가져옴
    for n in k_num.split('0'):
        if n == "": continue
        if is_prime_num(int(n)):  # n이 소수인 경우 answer+=1
            answer += 1
    return answer
