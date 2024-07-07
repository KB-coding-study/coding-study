# KB IT's your life 코딩테스트 스터디

- KB IT's Your Life 5기 알고리즘 스터디입니다.


[//]: # (# 0️⃣ 스터디 멤버)

[//]: # ()
[//]: # (<table>)

[//]: # (    <tr>)

[//]: # (        <td align="center">)

[//]: # (	    <a href="https://github.com/rlagkswn00">)

[//]: # (	    	<img src="https://avatars.githubusercontent.com/u/56250226?v=4" width="100px;" alt=""/>)

[//]: # (	    	<br/>)

[//]: # (	    	<sub>)

[//]: # (	    	<b>김한주</b>)

[//]: # (	    	<br/>)

[//]: # (	    	<img src="https://us-central1-progress-markdown.cloudfunctions.net/progress/100"/>)

[//]: # (	        </sub>)

[//]: # (	    </a>)

[//]: # (	    <br />)

[//]: # (	</td>)

[//]: # (        <td align="center">)

[//]: # (	    <a href="https://github.com/lcy923">)

[//]: # (	    	<img src="https://avatars.githubusercontent.com/u/81132057?v=4" width="100px;" alt=""/>)

[//]: # (	    	<br/>)

[//]: # (	    	<sub>)

[//]: # (	    	<b>이채영</b>)

[//]: # (	    	<br/>)

[//]: # (	    	<img src="https://us-central1-progress-markdown.cloudfunctions.net/progress/100"/>)

[//]: # (	        </sub>)

[//]: # (	    </a>)

[//]: # (	    <br />)

[//]: # (	</td>)

[//]: # (        <td align="center">)

[//]: # (	    <a href="https://github.com/gaamjaa">)

[//]: # (	    	<img src="https://avatars.githubusercontent.com/u/49315208?v=4" width="100px;" alt=""/>)

[//]: # (	    	<br/>)

[//]: # (	    	<sub>)

[//]: # (	    	<b>이해연</b>)

[//]: # (	    	<br/>)

[//]: # (	    	<img src="https://us-central1-progress-markdown.cloudfunctions.net/progress/100"/>)

[//]: # (	        </sub>)

[//]: # (	    </a>)

[//]: # (	    <br />)

[//]: # (	</td>)

[//]: # (	<td align="center">)

[//]: # (	    <a href="https://github.com/mellykim123">)

[//]: # (	    	<img src="https://avatars.githubusercontent.com/u/78676660?v=4" width="100px;" alt=""/>)

[//]: # (	    	<br/>)

[//]: # (	    	<sub>)

[//]: # (	    	<b>김지은</b>)

[//]: # (	    	<br/>)

[//]: # (	    	<img src="https://us-central1-progress-markdown.cloudfunctions.net/progress/100"/>)

[//]: # (	        </sub>)

[//]: # (	    </a>)

[//]: # (	    <br />)

[//]: # (	</td>)

[//]: # (	<td align="center">)

[//]: # (	    <a href="https://github.com/kseop">)

[//]: # (	    	<img src="https://avatars.githubusercontent.com/u/42964809?v=4" width="100px;" alt=""/>)

[//]: # (	    	<br/>)

[//]: # (	    	<sub>)

[//]: # (	    	<b>강태섭</b>)

[//]: # (	    	<br/>)

[//]: # (	    	<img src="https://us-central1-progress-markdown.cloudfunctions.net/progress/100"/>)

[//]: # (	        </sub>)

[//]: # (	    </a>)

[//]: # (	    <br />)

[//]: # (	</td>)

[//]: # (    </tr>)

[//]: # (</table>)

[//]: # (# 1️⃣ 진행 방법)

[//]: # ()
[//]: # (1. 본인 로컬 환경에서 문제 풀이를 진행한다.)

[//]: # (2. 원격 저장소에서 코드를 받아와 로컬 status를 최신화한다. &#40;pull&#41;)

[//]: # (3. 본인이 작성한 코드를 포함한 로컬 status를 원격 저장소로 보낸다. &#40;push&#41;)

[//]: # (4. 반드시 `commit message 규칙`을 지켜서 업로드 한다.)

[//]: # (5. 애매한 사항이 있으면 팀원들과 상의한 뒤 결정한다.)

[//]: # (6. _절대! 남의 폴더는 건들지 말 것!_)
# 0️⃣ 진행 방식
- 목표: 매일 1문제 이상 풀기
- 매주 알고리즘 주제를 정해 [바킹독의 실전 알고리즘](https://github.com/encrypted-def/basic-algo-lecture/blob/master/workbook.md)에서 해당 알고리즘의 ✔ 표시 된 문제 풀이
- 매일 아침 9시까지 코드 **본인 브랜치에 push** 후 **main에 본인 브랜치 PR**
- 다음날 오전 12시까지 다른 팀원의 코드리뷰 후 merge 진행

# 1️⃣ 소스코드 파일 이름 규칙

- 문제출처\_문제번호
- `BOJ_1234`
- 문제출처 작성 통일
    - BOJ - 백준
    - PGS - 프로그래머스

[//]: # (    - SEA - 삼성 SW Expert Acadamy)
    

# 2️⃣ commit message 규칙

- commit 메세지: N주차-이름-문제번호

```shell
git commit -m "[N]주차-[이름]-[문제번호]"
```

# 3️⃣ PR 규칙
## PR 제목
- N주차-이름-날짜
- `2주차-홍길동-0507 `
## comment 양식
> N주차 PR
> ---
> 당일 커밋 후 올린 문제 pr에서 체크
> + [x] 월요일
> + [ ] 화요일
> + [ ] 수요일
> + [ ] 목요일
> + [ ] 금요일
> + [ ] 토요일
- 이외 comment는 자유
- 해결 못한 문제가 있다면 어디서 막혔는지 작성하기 ⇒ 코드리뷰할때 같이 해결

# 4️⃣ (option) 코드리뷰 규칙

- PR에서 코드리뷰 진행
- 의견제시
    - 잘했다고 생각하는 부분
    - 이렇게 하면 더 좋을 것 같다고 생각하는 부분
    - 왜 이렇게 풀었는지 궁금한 부분
    - 또 다른 풀이 방식 제시
- 코드의 일부에다가 코드리뷰를 해도 되고 전체 코드 밑 또는 PR 하나 밑에다 코멘트 작성으로 리뷰를 해도 됩니다.

# ✅ 문제

<table>
    <!-- 1주차 문제 -->
    <tr style="text-align: center">
        <td rowspan="9">1주차<br>배열, 문자열</td>
        <td>BOJ</td><td>2577</td><td><a href="https://www.acmicpc.net/problem/2577">숫자의 개수</a></td><td>브론즈2</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1475</td><td><a href="https://www.acmicpc.net/problem/1475">방 번호</a></td><td>실버5</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>3273</td><td><a href="https://www.acmicpc.net/problem/3273">두 수의 합</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>3613</td><td><a href="https://www.acmicpc.net/problem/3613">Java vs C++</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2870</td><td><a href="https://www.acmicpc.net/problem/2870">수학숙제</a></td><td>실버4</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1969</td><td><a href="https://www.acmicpc.net/problem/1969">DNA</a></td><td>실버4</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2999</td><td><a href="https://www.acmicpc.net/problem/2999">비밀 이메일</a></td><td>브론즈1</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>9536</td><td><a href="https://www.acmicpc.net/problem/9536">여우는 어떻게 울지?</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>15312</td><td><a href="https://www.acmicpc.net/problem/15312">이름 궁합</a></td><td>실버5</td>
        <td>기본 문제✔</td>
    </tr>
    <!-- 2주차 문제 -->
    <tr style="text-align: center">
        <td rowspan="7">2주차<br>스택, 큐, 덱</td>
        <td>BOJ</td><td>10773</td><td><a href="https://www.acmicpc.net/problem/10773">제로</a></td><td>실버4</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1874</td><td><a href="https://www.acmicpc.net/problem/1874">스택 수열</a></td><td>실버2</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2493</td><td><a href="https://www.acmicpc.net/problem/2493">탑</a></td><td>골드5</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>18258</td><td><a href="https://www.acmicpc.net/problem/18258">큐 2</a></td><td>실버4</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2164</td><td><a href="https://www.acmicpc.net/problem/2164">카드 2</a></td><td>실버4</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1021</td><td><a href="https://www.acmicpc.net/problem/1021">회전하는 큐</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>5430</td><td><a href="https://www.acmicpc.net/problem/5430">AC</a></td><td>골드5</td>
        <td>응용 문제✔</td>
    </tr>
<!-- 3주차 문제 -->
    <tr style="text-align: center">
        <td rowspan="8">3주차<br>정렬, BFS(기본) </td>
        <td>BOJ</td><td>5648</td><td><a href="https://www.acmicpc.net/problem/5648">역원소 정렬</a></td><td>실버5</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1181</td><td><a href="https://www.acmicpc.net/problem/1181">단어 정렬</a></td><td>실버5</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2910</td><td><a href="https://www.acmicpc.net/problem/2910">빈도 정렬</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1012</td><td><a href="https://www.acmicpc.net/problem/1012">유기농 배추</a></td><td>실버2</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>10026</td><td><a href="https://www.acmicpc.net/problem/10026">적록색약</a></td><td>골드5</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>7569</td><td><a href="https://www.acmicpc.net/problem/7569">토마토</a></td><td>골드5</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>7562</td><td><a href="https://www.acmicpc.net/problem/7562">나이트의 이동</a></td><td>실버1</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>5427</td><td><a href="https://www.acmicpc.net/problem/5427">불</a></td><td>골드4</td>
        <td>기본 문제✔</td>
    </tr>
<!-- 4주차 문제 -->
    <tr style="text-align: center">
        <td rowspan="6">4주차<br>BFS(심화) </td>
        <td>BOJ</td><td>2206</td><td><a href="https://www.acmicpc.net/problem/2206">벽 부수고 이동하기</a></td><td>골드3</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>9466</td><td><a href="https://www.acmicpc.net/problem/9466">텀프로젝트</a></td><td>골드3</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2573</td><td><a href="https://www.acmicpc.net/problem/2573">빙산</a></td><td>골드4</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2146</td><td><a href="https://www.acmicpc.net/problem/2146">다리 만들기</a></td><td>골드3</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>13549</td><td><a href="https://www.acmicpc.net/problem/13549">숨바꼭질 3</a></td><td>골드5</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1600</td><td><a href="https://www.acmicpc.net/problem/1600">말이 되고픈 원숭이</a></td><td>골드3</td>
        <td>응용 문제✔</td>
    </tr>
<!-- 5주차 문제 -->
    <tr style="text-align: center">
        <td rowspan="6">5주차<br>DFS(기본, 심화) </td>
        <td>BOJ</td><td>2606</td><td><a href="https://www.acmicpc.net/problem/2606">바이러스</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>11724</td><td><a href="https://www.acmicpc.net/problem/11724">연결 요소의 개수</a></td><td>실버2</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2644</td><td><a href="https://www.acmicpc.net/problem/2644">촌수계산</a></td><td>실버2</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>13023</td><td><a href="https://www.acmicpc.net/problem/13023">ABCDE</a></td><td>골드5</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2668</td><td><a href="https://www.acmicpc.net/problem/2668">숫자고르기</a></td><td>골드5</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1967</td><td><a href="https://www.acmicpc.net/problem/1967">트리의 지름</a></td><td>골드4</td>
        <td>응용 문제✔</td>
    </tr>
<!-- 6주차 문제 -->
    <tr style="text-align: center">
        <td rowspan="6">6주차<br>투 포인터 </td>
        <td>BOJ</td><td>1644</td><td><a href="https://www.acmicpc.net/problem/1644">소수의 연속합</a></td><td>골드3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2003</td><td><a href="https://www.acmicpc.net/problem/2003">수들의 합 2</a></td><td>실버4</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>13144</td><td><a href="https://www.acmicpc.net/problem/13144">List of Unique Numbers</a></td><td>골드4</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>22862</td><td><a href="https://www.acmicpc.net/problem/22862">가장 긴 짝수 연속한 부분 수열 (large)</a></td><td>골드5</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2531</td><td><a href="https://www.acmicpc.net/problem/2531">회전 초밥</a></td><td>실버1</td>
        <td>응용 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>20922</td><td><a href="https://www.acmicpc.net/problem/20922">겹치는 건 싫어</a></td><td>실버1</td>
        <td>응용 문제✔</td>
    </tr>
<!-- 7주차 문제 -->
    <tr style="text-align: center">
        <td rowspan="11">7주차<br>다이나믹 프로그래밍</td>
        <td>BOJ</td><td>1003</td><td><a href="https://www.acmicpc.net/problem/1003">피보나치 함수</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1932</td><td><a href="https://www.acmicpc.net/problem/1932">정수 삼각형</a></td><td>실버1</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>11727</td><td><a href="https://www.acmicpc.net/problem/11727">2×n 타일링 2</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>2193</td><td><a href="https://www.acmicpc.net/problem/2193">이친수</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>1912</td><td><a href="https://www.acmicpc.net/problem/1912">연속합</a></td><td>실버2</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>11055</td><td><a href="https://www.acmicpc.net/problem/11055">가장 큰 증가하는 부분 수열</a></td><td>실버2</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>11053</td><td><a href="https://www.acmicpc.net/problem/11053">가장 긴 증가하는 부분 수열</a></td><td>실버2</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>9461</td><td><a href="https://www.acmicpc.net/problem/9461">파도반 수열</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>14501</td><td><a href="https://www.acmicpc.net/problem/14501">퇴사</a></td><td>실버3</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>15486</td><td><a href="https://www.acmicpc.net/problem/15486">퇴사2</a></td><td>골드5</td>
        <td>기본 문제✔</td>
    </tr>
    <tr style="text-align: center">
        <td>BOJ</td><td>10844</td><td><a href="https://www.acmicpc.net/problem/10844">쉬운 계단 수</a></td><td>실버1</td>
        <td>기본 문제✔</td>
    </tr>
</table>

