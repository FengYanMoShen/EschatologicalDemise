package net.eschatologicaldemise;

import java.util.Scanner;

public class QuadraticFunction {

    public static void main(String[] args) {
        // 创建一个Scanner对象，用来接收用户输入
        Scanner input = new Scanner(System.in);

        // 提示用户输入三个点的坐标
        System.out.println("输入由空格分隔的三个点的坐标:");
        System.out.println("例如: \n" +
                "x1 \n" +
                "y1 \n" +
                "x2 \n" +
                "y2 \n" +
                "x3 \n" +
                "y3 \n");

        // 接收用户输入，并存储在变量中
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        // 根据用户输入的坐标，构造三个方程
        double[][] equations = {
                {x1 * x1, x1, 1, y1},
                {x2 * x2, x2, 1, y2},
                {x3 * x3, x3, 1, y3}
        };

        // 调用自定义的方法，用消元法解方程组，并返回结果数组
        double[] result = solveEquationsByElimination(equations);
        System.out.println(
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "========================================================" +
                "\n" +
                "\n");

        // 判断结果数组是否为空，如果为空，则说明方程组无解或无唯一解；如果不为空，则说明方程组有唯一解
        if (result == null) {
            System.out.println("The equation has no solution or no unique solution.");
        } else {
            // 将结果数组中的元素赋值给对应的变量
            double a = result[0];
            double b = result[1];
            double c = result[2];

            // 打印出一元二次函数的解析式
            System.out.println("The quadratic function is: ");
            System.out.println("y = " + a + "x^2 + " + b + "x + " + c);
        }
    }

    // 定义一个自定义的方法，用消元法解方程组，并返回结果数组
    public static double[] solveEquationsByElimination(double[][] equations) {
        // 获取方程组的行数和列数
        int rows = equations.length;
        int columns = equations[0].length;

        // 遍历方程组的每一行，进行消元操作
        for (int i = 0; i < rows; i++) {
            // 如果当前行的对角线元素为0，则寻找下面的行，找到一个不为0的元素，并与当前行交换
            if (equations[i][i] == 0) {
                int j;
                for (j = i + 1; j < rows; j++) {
                    if (equations[j][i] != 0) {
                        break;
                    }
                }
                // 如果找不到不为0的元素，则说明方程组无解或无唯一解，返回空数组
                if (j == rows) {
                    return null;
                }
                // 如果找到不为0的元素，则与当前行交换
                else {
                    double[] temp = equations[i];
                    equations[i] = equations[j];
                    equations[j] = temp;
                }
            }

            // 将当前行的对角线元素化为1，即将当前行的每个元素除以对角线元素
            double divisor = equations[i][i];
            for (int k = 0; k < columns; k++) {
                equations[i][k] /= divisor;
            }

            // 将下面的行的第i列元素化为0，即将当前行的每个元素乘以一个系数，并从下面的行中减去
            for (int m = i + 1; m < rows; m++) {
                double multiplier = equations[m][i];
                for (int n = 0; n < columns; n++) {
                    equations[m][n] -= multiplier * equations[i][n];
                }
            }
        }

        // 创建一个结果数组，用来存储方程组的解
        double[] result = new double[rows];

        // 从最后一行开始，进行回代操作，求出每个变量的值，并存入结果数组中
        for (int i = rows - 1; i >= 0; i--) {
            result[i] = equations[i][columns - 1];
            for (int j = i - 1; j >= 0; j--) {
                equations[j][columns - 1] -= result[i] * equations[j][i];
            }
        }

        // 返回结果数组
        return result;
    }
}
