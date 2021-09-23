# Notepad REST API
## 개발 환경
* Java
* MySQL
* gradle
* IDE: IntelliJ
* TEST: postman

## Table of Contents
* [Create](#Create)
* [Read](#Read)
* [Update](#Update)
* [Delete](#Delete)

## Create
* URL: <http://localhost:8080/memos>
* HttpStatus code: 201  
<img src="https://user-images.githubusercontent.com/50009240/134508118-356a7656-b7d9-491e-aad9-c123a560a965.png" width="1036px" height="462px"></img><br/>

## Read
### 날짜별 메모정보 검색
* URL: <http://localhost:8080/memos?date={date}&page={page}>
    * {data} format: yyyy-mm-dd
    * {page} format: integer
* HttpStatus code: 200 
<img src="https://user-images.githubusercontent.com/50009240/134511512-e6a3f06a-ce4b-434a-9913-9bfdbf70ef7f.png" width="1036px" height="814px"></img><br/>
#### 검색 실패
* 해당 date의 메모가 존재하지 않는 경우
* 해당 page의 메모가 존재하지 않는 경우
* HttpStatus code: 404
<img src="https://user-images.githubusercontent.com/50009240/134512488-ba34066f-62f5-421a-a5a7-a39fc93aeb8c.png" width="1036px" height="404px"></img><br/>

### 상세정보 검색
* URL: <http://localhost:8080/memos/{memoId}>
* HttpStatus code: 200
<img src="https://user-images.githubusercontent.com/50009240/134518560-48b38871-0b37-449a-ab3e-55ccaa754f07.png" width="1036px" height="390px"></img><br/>
#### 검색 실패
* 해당 Id의 메모가 존재하지 않는 경우
* HttpStatus code: 404
<img src="https://user-images.githubusercontent.com/50009240/134518801-45ab4787-3eee-445e-a5c2-dbe2b55daf0b.png" width="1036px" height="390px"></img><br/>

### 전체 상세정보 조회
* URL: <http://localhost:8080/memos/all>
* HttpStatus code: 200
<img src="https://user-images.githubusercontent.com/50009240/134519838-5533bed1-71af-49b7-9b17-c8caea67a829.png" width="1038px" height="810px"></img><br/>
#### 조회 실패
* 어떠한 메모도 존재하지 않는 경우
* HttpStatus code: 404
<img src="https://user-images.githubusercontent.com/50009240/134520063-bf7904ea-64e9-475b-bb4d-e60fc25b5246.png" width="1037px" height="436px"></img><br/>

## Update
* URL: <http://localhost:8080/memos/{memoId}>
* HttpStatus code: 200
<img src="https://user-images.githubusercontent.com/50009240/134508957-a5d21bbe-1d6b-4755-9799-04ef76c706f0.png" width="1036px" height="438px"></img><br/>
#### 메모 수정 실패
* 해당 Id의 메모가 존재하지 않는 경우
* HttpStatus code: 404  
<img src="https://user-images.githubusercontent.com/50009240/134510034-2edf8d41-092d-4111-a50e-3e9822152a7e.png" width="1034px" height="479px"></img><br/>

## Delete
* URL: <http://localhost:8080/memos/{memoId}>
* HttpStatus code: 200
<img src="https://user-images.githubusercontent.com/50009240/134510619-e7b099db-1f10-45e4-9988-1c4bb9168703.png" width="1036px" height="360px"></img><br/>
#### 메모 삭제 실패
* 해당 Id의 메모가 존재하지 않는 경우
* HttpStatus code: 404
<img src="https://user-images.githubusercontent.com/50009240/134510828-26997555-4d22-4ceb-8237-85c00e77a219.png" width="1032px" height="477px"></img><br/>




