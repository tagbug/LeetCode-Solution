"use strict"
/**
 * 背包问题：
 * 
 * @param {Number} n n个游戏
 * @param {Number} X 总预算
 * @param {Number[]} a 游戏原价
 * @param {Number[]} b 优惠后的[现价]
 * @param {Number[]} w 购买游戏获得的[快乐值]
 * @returns 总优惠金额不低于超过预算的金额的前提下，尽可能多的快乐值(Σa[i]-b[i] >= Σb[i] - X)
 */
function bag(n, X, a, b, w) {
    // 计算最大容量
    const MAX_W = X;
    for (let i = 0; i < n; i++) {
        MAX_W += Math.max(0, a[i] - 2 * b[i]);
    }
    // 背包dp
    const dp = new Array(n + 1);

    // 初始状态
    for (let i = 0; i <= n; i++) {
        dp[i] = new Array(MAX_W + 1);
        dp[0][i] = 0;
    }

    // dp
    for (let i = 1; i <= n; i++) {
        let weight = Math.max(0, 2 * b[i - 1] - a[i - 1]);
        for (let j = MAX_W; j >= weight; j--) {
            // 可以选择买不买
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + w[i - 1]);
        }
    }

    // 求结果
    let max = 0;
    for (let i = 0; i <= MAX_W; i++) {
        max = Math.max(dp[n][i], max);
    }
    return max;
}