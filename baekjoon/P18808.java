import java.util.*;

public class P18808{
    static List<int[][]> stickers = new ArrayList<>();
    static int[][] notebook;
    static int[][] stickerSize;
    static int N,M,K;
    static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        notebook = new int[N][M];
        stickerSize = new int[K][2];

        for(int i=0; i<K; i++){
            stickerSize[i][0] = sc.nextInt();
            stickerSize[i][1] = sc.nextInt();

            int[][] st = new int[stickerSize[i][0]][stickerSize[i][1]];
            for(int j=0; j<stickerSize[i][0]; j++){
                for(int k=0; k<stickerSize[i][1]; k++){
                    st[j][k] = sc.nextInt();
                }
            }

            stickers.add(st);
        }

        for(int i=0; i<K; i++){
            attach(i);
        }

        System.out.println(result);

        sc.close();
    }

    static void attach(int index){
        int[][] sticker = stickers.get(index);
        int[] st = stickerSize[index];

        for(int k=0; k<4; k++){
            int r = st[0];
            int c = st[1];
            if(k!=0){
                if(k%2 == 0){
                    sticker = rotate(sticker, st[0], st[1]);
                    r = st[0];
                    c = st[1];
                }else{
                    sticker = rotate(sticker, st[1], st[0]);
                    r = st[1];
                    c = st[0];
                }
            }
            for(int n = 0; n<N; n++){
                for(int m=0; m<M; m++){
                    boolean attachable = true;
                    for(int i=0; i<r; i++){
                        for(int j=0; j<c; j++){

                            if(OOB(n+i, m+j) || (notebook[n+i][m+j] == 1 && sticker[i][j] == 1)){
                                attachable = false;
                                break;
                            }
                        }
                        if(!attachable) break;
                    }

                    int cnt = 0;

                    if(attachable){
                        for(int i=0; i<r; i++){
                            for(int j=0; j<c; j++){
                                if(sticker[i][j] == 1){
                                    notebook[n+i][m+j] = 1;
                                    cnt++;
                                }
                            }
                        }

                        result += cnt;

                        return;
                    }
                }
            }
        }

        return;
    }

    static int[][] rotate(int[][] sticker, int r, int c){
        int[][] ret = new int[r][c];

        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                ret[j][c-i-1] = sticker[i][j];
            }
        }

        return ret;
    }

    static boolean OOB(int x, int y){
        return x >= N || y >= M;
    }

    static void print(int[][] sticker, int r, int c){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(sticker[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}