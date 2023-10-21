package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 게임에 사용되는 3자리 숫자 배열 정의
    int[] playerNumbers = new int[3]; // 플레이어
    int[] randomNumbers = new int[3]; // 컴퓨터

    public static void main(String[] args) {
        Application app = new Application();
        app.startGame();
    }

    // 게임 실행 메서드
    public void startGame() {
        generateRandomNumbers();
        getPlayerNumbers();
        String result = checkStrikesOrBall(randomNumbers, playerNumbers);
        System.out.println(result);
    }

    // 스트라이크 & 볼 계산 로직
    public String checkStrikesOrBall(int[] randomNumbers, int[] playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < playerNumbers.length; i++) {
            if (playerNumbers[i] == randomNumbers[i]) {
                strikes++;
            } else if (containsNumber(randomNumbers, playerNumbers[i])) {
                balls++;
            }
        }
        return String.format("%d스트라이크 %d볼", strikes, balls);
    }

    private boolean containsNumber(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    // 난수 생성 및 배열에 저장하는 메서드
    private void generateRandomNumbers() {
        for (int i = 0; i < 3; i++) {
            randomNumbers[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    // 플레이어로 부터 숫자를 받는 메서드
    private void getPlayerNumbers() {
        for (int i = 0; i < 3; i++) {
            System.out.println("숫자를 입력해주세요 : ");
            int playerNumber = Integer.parseInt(Console.readLine());

            if (playerNumber < 1 || playerNumber > 9) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
            }
            playerNumbers[i] = playerNumber;
        }
    }
}
