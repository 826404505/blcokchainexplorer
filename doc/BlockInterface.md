##1.根据交易的height,hash，adress查看Transaction信息，和包含在内的交易列表

####1.1根据交易的height查看Transaction信息，和包含在内的交易列表

 调用该API，可以根据块的height查找一个指定Transaction的详细信息
- **param参数**：height
```json
url:http://localhost:8080/transaction/getRecentTransacionsByHeight?height={height}
method:Get
successResponse{
    "TransactionList":[
      {
        "txId" : '2850ccc6b3bfad536511e596895ae6b6a6519ce763a96cda1edb62fa922b5a4a'
        "txHash" : '3Cf2YGcwVpKSuwp4SEskBVsnv7W39uPQ3P'
        "txTime" : '2019-04-16 11:42:05'
        "amount" : '0.0038742 BTC'
      }
      {
          ...
      }
    ]
}
```
| txId | txHash | txTime | amount |
|:-------------:| :-------------: | :-------------: | :-------------: 
| 交易ID | 交易hash | 交易时间 | 交易总量|
| 2850ccc6b3bfad536511e596895ae6b6a6519ce763a96cda1edb62fa922b5a4a | 3Cf2YGcwVpKSuwp4SEskBVsnv7W39uPQ3P | 2019-04-16 11:42:05 | 0.0038742 BTC | 

####1.2根据区块的hash查看区块信息，和包含在内的交易列表

 调用该API可以在搜索框里输入指定的hash值搜索Transaction的详细信息
- **param参数**：hash值
```json
url:http://localhost:8080/transaction/getRecentTransacionsByHash?hash={hash}
method:Get
successResponse{
    "TransactionList":[
      {
        "txId" : '16FHpnpWZ5LZiD6LAyheM7V7sRD7NxgBjm1ARbkbCRM7VrUQ18wwvAWrKi2SQjpMm7au'
        "txHash" : '085731ef2001b0fef7a832aa7bdd6ae5169990acf2435a8143c3479a83270da9'
        "txTime" : '2019-04-16 11:58:22'
        "amount" : '0 BTC'
      }
      {
          ...
      }
    ]
}
```
| txId | txHash | txTime | amount |
|:-------------:| :-------------: | :-------------: | :-------------: 
| 交易ID | 交易hash | 交易时间 | 交易总量|
| 16FHpnpWZ5LZiD6LAyheM7V7sRD7NxgBjm1ARbkbCRM7VrUQ18wwvAWrKi2SQjpMm7au | 085731ef2001b0fef7a832aa7bdd6ae5169990acf2435a8143c3479a83270da9 | 2019-04-16 11:58:22 | 0 BTC |

####1.3根据交易的adress查询单个Transaction

调用该API可以查找一个详细的Transaction信息
- **param参数**：adress
```json
url:http://localhost:8080/transaction/getRecentTransacionsByAddress?address={address}
method:Get
successResponse{
    "TransactionList":[
      {
        "txId" : '16FHpnpWZ5LZiD6LAyheM7V7sRD7NxgBjm1ARbkbCRM7VrUQ18wwvAWrKi2SQjpMm7au'
        "txHash" : '085731ef2001b0fef7a832aa7bdd6ae5169990acf2435a8143c3479a83270da9'
        "txTime" : '2019-04-16 11:58:22'
        "amount" : '0 BTC'
      }
      {
          ...
      }
    ]
}
```
| txId | txHash | txTime | amount |
|:-------------:| :-------------: | :-------------: | :-------------: 
| 交易ID | 交易hash | 交易时间 | 交易总量|
| 16FHpnpWZ5LZiD6LAyheM7V7sRD7NxgBjm1ARbkbCRM7VrUQ18wwvAWrKi2SQjpMm7au | 085731ef2001b0fef7a832aa7bdd6ae5169990acf2435a8143c3479a83270da9 | 2019-04-16 11:58:22 | 0 BTC |

##2.Block信息
 ---
 ####2.1通过币种和类型获取block列表
 ```
 调用该API的时候可以获取指定blcok的详细信息
 ```
- **param参数**
    ######1.name
    ######2.type
- **block对象的信息**
```json
url:http://localhost:8080/block/getRecentBlocksByNameAndType?name={name}&type={type}
method:GET
successResponse{
    "BlockInfoList":[
        {
        "height":571879
        "time":"2019-04-16 11:56:21"
        "txSize":1204
        "sizeOnDisk":1204
        }
        {
            ...
        }
    ]
}
```
| height | time | txSize | sizeOnDisk | 
| :----------: | :----------: | :----------: | :----------:|
| 块高度 | 时间 | 交易所占大小 | 块大小 |
| 571879 | 2019-04-16 11:56:21 | 1204 | 1204 |

---
 ####2.2通过区块链ID获取block列表
 ```
 调用该API的时候通过blockChainId可以获取指定blcok的列表
 ```
- **param参数**
    ######1.blockChainId
- **block对象的信息**
```json
url:http://http://localhost:8080/block/getRecentBlocksById?blockchainId={blockchainId}
method:GET
successResponse{
    "BlockChainList":[
        {
        "height":571879
        "time":"2019-04-16 11:56:21"
        "txSize":1204
        "sizeOnDisk":1204
        }
        {
            ...
        }
    ]
}
```
| height | time | txSize | sizeOnDisk | 
| :----------: | :----------: | :----------: | :----------:|
| 块高度 | 时间 | 交易所占大小 | 块大小 |
| 571879 | 2019-04-16 11:56:21 | 1204 | 1204 |
|...|

 ####2.3通过块的height获取block的详细信息
 ```
 调用该API的时候通过块的height可以获取指定blcok的列表
 ```
- **param参数**
    ######1.height
- **block对象的信息**
```json
url:http://http://localhost:8080/block/getBlockDetailByHeight?height={height}
method:GET
successResponse{
    "blockDetailDto":{
           "blockHash":'000000000000000000166cf3fa436c9bb477ae497baf77141dd7ad6a88a035ab'
           "blockHeight":571885
           "blockTime":"2019-04-16 13:10:24"
           "txSize":1063.996
           "sizeOnDisk":1063.996
           "blockDiffculty":6393023717201.86
           "blockPrevBlockhsah":'000000000000000000051ad1a35b216a0a8294f62c2ef5f9d57f59688e8d563d'
           "blockNextBlockhash":''
           "blockOutputtotal":12578.58754136
           "transactionFees":0.84621048
           "merkleRoot":'5e835c107f7b90a0fc637a36c432b5b9b18b7ccb3ae745760ddb25a74ce78643'
        }
}
```
| 属性 | 值 |
| :---: | :---: | 
| blockHash | 000000000000000000166cf3fa436c9bb477ae497baf77141dd7ad6a88a035ab |
| blockHeight | 571885 |
| blockTime | 2019-04-16 13:10:24 |
| txSize | 1063.996 |
| sizeOnDisk | 1063.996 |
| blockDiffculty | 6393023717201.86 |
| blockPrevBlockhsah | 000000000000000000108efb74e799ec2529cc14908c167a6b9054a0bf09196e |
| blockNextBlockhash |  |
| blockOutputtotal | 12578.58754136 |
| transactionFees | 0.84621048 |
| merkleRoot | 5e835c107f7b90a0fc637a36c432b5b9b18b7ccb3ae745760ddb25a74ce78643 |
| ... |

### 1.4 通过块的HASH值 获取block的详细信息
```
调用该API 通过块的HASH值获取该块的详细信息
```

- **param参数**
    ###### 1.blockHash
- **block的详细信息**
    
```json
url:http://localhost:8080/block/getBlockDetailByHash?blockHash={blockHash}
method:GET
successResponse{
    "blockDetailDto":{
       "blockHash":'0000000000000000000618ee4517fbcb7dbd8fc1950b763167dd776678785625'
       "blockHeight":571874
       "blockTime":"2019-04-16 10:07:07"
       "txSize":1245.1
       "sizeOnDisk":1272.864
       "blockDiffculty":6393023717201.86
       "blockPrevBlockhsah":'000000000000000000051ad1a35b216a0a8294f62c2ef5f9d57f59688e8d563d'
       "blockNextBlockhash":'0000000000000000001bc486812183036a862f5f290488c1ff5bce6f9e523668'
       "blockOutputtotal":12578.58754136
       "transactionFees":0.92649811
       "merkleRoot":'e8d126790224f9363ef6cb06620209cd046f6560634019c4e729fbd7ae256f99'
    }
}
```


|属性|值|
|:---:|:---:|
|blockHash| 0000000000000000000618ee4517fbcb7dbd8fc1950b763167dd776678785625|
|blockHeight| 571874|
|blockTime| 2019-04-16 10:07:07|
|txSize| 1245.1|
|sizeOnDisk| 1272.864|
|blockDiffculty| 6393023717201.86|
|blockPrevBlockhsah| 000000000000000000051ad1a35b216a0a8294f62c2ef5f9d57f59688e8d563d|
|blockNextBlockhash| 0000000000000000001bc486812183036a862f5f290488c1ff5bce6f9e523668|
|blockOutputtotal| 12578.58754136|
|transactionFees| 0.92649811|
|merkleRoot| e8d126790224f9363ef6cb06620209cd046f6560634019c4e729fbd7ae256f99|
|...|
