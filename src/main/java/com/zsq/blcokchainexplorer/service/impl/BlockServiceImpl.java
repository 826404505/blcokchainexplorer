package com.zsq.blcokchainexplorer.service.impl;

import com.zsq.blcokchainexplorer.api.BitcoinJsonRpcClient;
import com.zsq.blcokchainexplorer.dao.BlockMapper;
import com.zsq.blcokchainexplorer.dao.TransactionMapper;
import com.zsq.blcokchainexplorer.dto.BlockDetailDTo;
import com.zsq.blcokchainexplorer.dto.BlockListDTO;
import com.zsq.blcokchainexplorer.po.Block;
import com.zsq.blcokchainexplorer.po.Transaction;
import com.zsq.blcokchainexplorer.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;


    /**
     * 根据hash值查找带有交易集合的blockDTO
     * @param blockhash
     * @return
     */
    @Override
    public BlockDetailDTo BlockDetailDToByHash(String blockhash) {
        //1、根据hash值查找block的信息
        //2、然后再根据hash值查找TransactionInBlockDTO的交易信息

        Block block = blockMapper.selectByPrimaryKey(blockhash);

        //根据hash查找TransactionInBlockDTO的信息
        Transaction transaction = transactionMapper.selectByBlockhash(blockhash);

        //把得到的信息进行封装
        BlockDetailDTo blockDetailDTo = new BlockDetailDTo();
        blockDetailDTo.setBlockhash(block.getBlockhash());
        blockDetailDTo.setDifficulty(block.getDifficulty());
        blockDetailDTo.setHeight(block.getHeight());
        blockDetailDTo.setTime(block.getTime());
        blockDetailDTo.setMerkleRoot(block.getMerkleRoot());
        blockDetailDTo.setTxSize(block.getTxSize());
        blockDetailDTo.setPrevBlockhash(block.getPrevBlockhash());
        blockDetailDTo.setNextBlockhash(block.getNextBlockhash());
        blockDetailDTo.setOutputTotal(block.getOutputTotal());
        blockDetailDTo.setTransactionFees(block.getTransactionFees());

        ArrayList<Transaction> transactionInBlockDTOS = new ArrayList<>();

        transactionInBlockDTOS.add(transaction);
        blockDetailDTo.setTransactions(transactionInBlockDTOS);

        return blockDetailDTo;
    }

    /**
     * 根据height查找block
     * @param blockheight
     * @return
     */
    @Override
    public BlockDetailDTo getBlockDetailByHeight(Integer blockheight) throws Throwable {
        //1、利用height得到hash值
        //2、根据hash值查找block的信息
        //3、然后再根据hash值查找TransactionInBlockDTO的交易信息

        //根据height查找blockhash
        String blockHashByHeight = bitcoinJsonRpcClient.getBlockHashByHeight(blockheight);
        Block block = blockMapper.selectByPrimaryKey(blockHashByHeight);

        //根据hash查找TransactionInBlockDTO的信息
        Transaction transaction = transactionMapper.selectByBlockhash(blockHashByHeight);

        //把得到的信息进行封装
        BlockDetailDTo blockDetailDTo = new BlockDetailDTo();
        blockDetailDTo.setBlockhash(block.getBlockhash());
        blockDetailDTo.setDifficulty(block.getDifficulty());
        blockDetailDTo.setHeight(block.getHeight());
        blockDetailDTo.setTime(block.getTime());
        blockDetailDTo.setMerkleRoot(block.getMerkleRoot());
        blockDetailDTo.setTxSize(block.getTxSize());
        blockDetailDTo.setPrevBlockhash(block.getPrevBlockhash());
        blockDetailDTo.setNextBlockhash(block.getNextBlockhash());
        blockDetailDTo.setOutputTotal(block.getOutputTotal());
        blockDetailDTo.setTransactionFees(block.getTransactionFees());

        ArrayList<Transaction> transactionInBlockDTOS = new ArrayList<>();

        transactionInBlockDTOS.add(transaction);
        blockDetailDTo.setTransactions(transactionInBlockDTOS);

        return blockDetailDTo;
    }

    /**
     * 根据blockchainId查找blockList的集合
     * @param blockchainId
     * @return
     */
    @Override
    public List<BlockListDTO> getBlockListByBlockchainId(Integer blockchainId) {
        List<BlockListDTO> blockListDTOByBlockchainId = blockMapper.getBlockListDTOByBlockchainId(blockchainId);

        return blockListDTOByBlockchainId;
    }
}
