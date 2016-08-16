package cn.ubingo.security.rsa.test;

import cn.ubingo.security.rsa.core.*;
import cn.ubingo.security.rsa.data.*;
import cn.ubingo.security.rsa.key.*;
/*
�·���(fochen,j@ubingo.cn)
2015-01-23
*/
public class Program {
	public static void main(String[] args) throws Exception
    {
		//������Կ��
        KeyPair keyPair = KeyGenerator.generateKeyPair();
        
        //ת���ɲ�ͬ�ĸ�ʽ
        KeyPair asnKeyPair = keyPair.toASNKeyPair();
        KeyPair xmlKeyPair = asnKeyPair.toXMLKeyPair();
        KeyPair pemKeyPair = xmlKeyPair.toPEMKeyPair();
        
        //��ȡ��˽Կ����asn��ʽ��Ϊ��
        String publicKey = asnKeyPair.getPublicKey();
        String privateKey = asnKeyPair.getPrivateKey();
        
        //ASN
        KeyWorker privateWorker = new KeyWorker(privateKey, KeyFormat.ASN);
        KeyWorker publicWorker = new KeyWorker(publicKey, KeyFormat.ASN);
                    
        System.out.print(privateWorker.decrypt(publicWorker.encrypt("��ã�����")));
        System.out.print(publicWorker.decrypt(privateWorker.encrypt("��ã��й�")));

        //XML
        privateWorker = new KeyWorker(xmlKeyPair.getPrivateKey(), KeyFormat.XML);
        publicWorker = new KeyWorker(xmlKeyPair.getPublicKey(), KeyFormat.XML);

        System.out.print(privateWorker.decrypt(publicWorker.encrypt("��ã�����")));
        System.out.print(publicWorker.decrypt(privateWorker.encrypt("��ã��й�")));

        //PEM
        privateWorker = new KeyWorker(pemKeyPair.getPrivateKey(), KeyFormat.PEM);
        publicWorker = new KeyWorker(pemKeyPair.getPublicKey(), KeyFormat.PEM);

        System.out.print(privateWorker.decrypt(publicWorker.encrypt("��ã�����")));
        System.out.print(publicWorker.decrypt(privateWorker.encrypt("��ã��й�")));
        
    }
}
