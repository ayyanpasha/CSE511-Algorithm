#include <iostream>
#include <vector>
#include <string>

const int MOD = 1'000'000'007;

// Function to multiply two matrices with modulo
std::vector<std::vector<long long>> multiply(
    const std::vector<std::vector<long long>>& a,
    const std::vector<std::vector<long long>>& b
) {
    int ra = a.size();
    int ca = a[0].size();
    int rb = b.size();
    int cb = b[0].size();
    std::vector<std::vector<long long>> result(ra, std::vector<long long>(cb, 0));
    
    for (int i = 0; i < ra; ++i) {
        for (int j = 0; j < cb; ++j) {
            long long sum = 0;
            for (int k = 0; k < ca; ++k) {
                sum = (sum + a[i][k] * b[k][j]) % MOD;
            }
            result[i][j] = sum;
        }
    }
    return result;
}

// Function to calculate the power matrix based on the input string
std::vector<std::vector<long long>> calculatePower(const std::string& n) {
    std::vector<std::vector<long long>> base(100, std::vector<long long>(100, 0));
    base[0][98] = 1;
    base[0][99] = 1;
    for (int i = 1; i < 100; ++i) {
        base[i][i-1] = 1;
    }
    
    std::vector<std::vector<long long>> result(100, std::vector<long long>(100, 0));
    for (int i = 0; i < 100; ++i) {
        result[i][i] = 1;
    }
    
    for (int i = n.size() - 1; i >= 0; --i) {
        std::vector<std::vector<long long>> z(100, std::vector<long long>(100, 0));
        for (int j = 0; j < 100; ++j) {
            z[j][j] = 1;
        }
        long long value = n[i] - '0';
        while (value > 0) {
            z = multiply(z, base);
            --value;
        }
        result = multiply(result, z);
        std::vector<std::vector<long long>> replace(100, std::vector<long long>(100, 0));
        for (int j = 0; j < 100; ++j) {
            replace[j][j] = 1;
        }
        
        for (long long j = 0; j < 10; ++j) {
            replace = multiply(replace, base);
        }
        base = replace;
    }
    return result;
}

int main() {
    std::string n;
    std::cin >> n;
    
    auto result = calculatePower(n);
    
    std::vector<std::vector<long long>> multiplyFactor(100, std::vector<long long>(1, 0));
    for (int j = 0; j <= 99; ++j) {
        multiplyFactor[j][0] = 99 - j;
    }
    
    result = multiply(result, multiplyFactor);
    
    std::cout << result[99][0] << std::endl;
    
    return 0;
}
