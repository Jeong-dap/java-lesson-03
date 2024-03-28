package kr.easw.lesson3;

import java.util.Random;

public class RollTheDice {
    private static int[] frequency = new int[6];

    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 600; i++) {
            if (RANDOM.nextDouble() < 0.1) {
                fillArray(RANDOM.nextDouble() * 720);
            } else {
                fillArray(RANDOM.nextDouble() * 360);
            }
        }
    }

    /**
     * 해당 메서드는 다음과 같은 역할을 가져야 합니다 :
     * 주어진 값을 60으로 나눈 후, 나온 값의 수만큼 해당 인덱스에 존재하는 배열 값을 1 증가시켜야 합니다.
     * 또한, 어떠한 경우에서도 주어진 기능을 구현했을 떄, 오류가 발생해서는 안됩니다.
     * <p>
     * 입력값은 일반적으로는 360을 넘지 않으나, 낮은 확률로 360을 넘습니다.
     * 이러한 경우, extendArray 메서드를 구현하여 이를 이용해 배열을 재선언해야 합니다.
     *
     * 또한, 입력값이 double임으로 60으로 나눈 이후 int로 캐스팅이 필요합니다.
     */
    private static void fillArray(double result) {
        int index = (int) (result / 60);
        if (index >= frequency.length) {
            frequency = extendArray(index + 1);
        }
        frequency[index]++;
    }

    private static int[] extendArray(int next) {
        int[] newArray = new int[next];
        System.arraycopy(frequency, 0, newArray, 0, frequency.length);
        return newArray;
    }
}