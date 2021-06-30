# blog-api

## 文章

### GET 按分类查询所有文章并分页

GET /article/category/{cid}/{page}/{size}

### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明     |
| ---- | ---- | ------ | ---- | -------- |
| cid  | path | string | true | 分类id   |
| page | path | string | true | 页号     |
| size | path | string | true | 分页大小 |

### GET 查询所有文章并分页

GET /article/{page}/{size}

### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明     |
| ---- | ---- | ------ | ---- | -------- |
| page | path | string | true | 页号     |
| size | path | string | true | 分页大小 |

### GET 查询所有归档

GET /article/archive

### GET 按归档查询所有文章并分页

GET /article/archive/{year}/{month}/{page}/{size}

#### 请求参数

| 名称  | 位置 | 类型   | 必选 | 说明     |
| ----- | ---- | ------ | ---- | -------- |
| year  | path | string | true | 年       |
| month | path | string | true | 月       |
| page  | path | string | true | 页号     |
| size  | path | string | true | 分页大小 |

### GET 查询所有文章

GET /article

### POST 新建或修改文章

POST /article

> Body 请求参数

```json
{
  "type": "object",
  "properties": {
    "aid": {
      "type": "integer",
      "description": "文章id"
    },
    "title": {
      "type": "string",
      "description": "文章标题"
    },
    "description": {
      "type": "string",
      "description": "简介"
    },
    "markdown": {
      "type": "string",
      "description": "Markdown"
    },
    "category": {
      "type": "object",
      "properties": {
        "cid": {
          "type": "integer",
          "description": "分类id"
        }
      },
      "required": [
        "cid"
      ],
      "description": "分类"
    },
    "tags": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "tid": {
            "type": "integer",
            "description": "标签id"
          }
        },
        "required": [
          "tid"
        ]
      },
      "description": "标签"
    }
  },
  "required": [
    "title",
    "description",
    "markdown",
    "category",
    "tags"
  ]
}
```

#### 请求参数

| 名称          | 位置 | 类型     | 必选  | 说明     |
| ------------- | ---- | -------- | ----- | -------- |
| body          | body | object   | false | none     |
| » aid         | body | integer  | false | 文章id   |
| » title       | body | string   | true  | 文章标题 |
| » description | body | string   | true  | 简介     |
| » markdown    | body | string   | true  | Markdown |
| » category    | body | object   | true  | 分类     |
| »» cid        | body | integer  | true  | 分类id   |
| » tags        | body | [object] | true  | 标签     |
| »» tid        | body | integer  | true  | 标签id   |

### GET 按标签查询所有文章并分页

GET /article/tag/{tid}/{page}/{size}

#### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明     |
| ---- | ---- | ------ | ---- | -------- |
| tid  | path | string | true | 标签id   |
| page | path | string | true | 页号     |
| size | path | string | true | 分页大小 |

## GET 按id查询文章

GET /article/{aid}

### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明   |
| ---- | ---- | ------ | ---- | ------ |
| aid  | path | string | true | 文章id |

## 分类

### POST 新建或修改分类

POST /category

> Body 请求参数

```json
{
  "type": "object",
  "properties": {
    "cid": {
      "type": "integer"
    },
    "name": {
      "type": "string"
    }
  },
  "required": [
    "name"
  ]
}
```

#### 请求参数

| 名称   | 位置 | 类型    | 必选  | 说明 |
| ------ | ---- | ------- | ----- | ---- |
| body   | body | object  | false | none |
| » cid  | body | integer | false | none |
| » name | body | string  | true  | none |

### GET 查询所有分类

GET /category

### GET 查询所有分类并分页

GET /category/{page}/{size}

#### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明     |
| ---- | ---- | ------ | ---- | -------- |
| page | path | string | true | 页号     |
| size | path | string | true | 分页大小 |

### GET 按id查询分类

GET /category/{cid}

#### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明   |
| ---- | ---- | ------ | ---- | ------ |
| cid  | path | string | true | 分类id |

## 标签

### GET 查询所有标签

GET /tag

### POST 新建或修改标签

POST /tag

> Body 请求参数

```json
{
  "type": "object",
  "properties": {
    "tid": {
      "type": "integer"
    },
    "name": {
      "type": "string"
    }
  },
  "required": [
    "name"
  ]
}
```

#### 请求参数

| 名称   | 位置 | 类型    | 必选  | 说明 |
| ------ | ---- | ------- | ----- | ---- |
| body   | body | object  | false | none |
| » tid  | body | integer | false | none |
| » name | body | string  | true  | none |

### GET 查询所有标签并分页

GET /tag/{page}/{size}

#### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明     |
| ---- | ---- | ------ | ---- | -------- |
| page | path | string | true | 页号     |
| size | path | string | true | 分页大小 |

### GET 按id查询标签

GET /tag/{tid}

#### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明   |
| ---- | ---- | ------ | ---- | ------ |
| tid  | path | string | true | 标签id |

## 用户

### GET 查询所有用户

GET /user

### GET 按id查询用户

GET /user/{uid}

#### 请求参数

| 名称 | 位置 | 类型   | 必选 | 说明   |
| ---- | ---- | ------ | ---- | ------ |
| uid  | path | string | true | 用户id |

