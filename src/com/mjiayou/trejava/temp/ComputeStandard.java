package com.mjiayou.trejava.temp;
//package com.test;
//
///**
// * Created by sunqiang on 15/5/12.
// */
//public class ComputeStandard {
//    float[] brightnessArr = {1.5f,3.5f,5f};
//    int brightnessN = brightnessArr.length;
//    float[][]standardArr;
//    public ComputeStandard()
//    {
//    	float[][][] scoreValueArr = {};
//    	float[][] _ScoreStandard;
//    	float[][] scoreValueArr;
//    	float[][] scoreLevelArr;
//
//        if (self = [super init]) {
//        self.standardArr = [[NSMutableArray alloc]initWithCapacity:self.brightnessN];
//
//        for (NSInteger i = 0; i<brightnessN; ++i) {
//            ScoreStandard* _ScoreStandard = [[ScoreStandard alloc]init];
//            NSMutableArray* scoreValueArr = [[NSMutableArray alloc]initWithCapacity:6];
//            NSMutableArray* scoreLevelArr = [[NSMutableArray alloc]initWithCapacity:6];
//
//            switch (i) {
//                case 0:
//                {
//                    //美白
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"68",@"140.4",@"300",@"340",@"366", nil]];
//                    //均匀度
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"4.0",@"2.48",@"2.22",@"1.57",@"0.92",@"0.66",@"0.4", nil]];
//                    //细纹
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.4",@"0.28",@"0.013",@"0.08",@"0.00001",nil]];
//                    //毛孔
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.2",@"0.14",@"0.09",@"0.06",@"0.03",@"0.00001", nil]];
//                    //色斑
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.6",@"0.42",@"0.27",@"0.233",@"0.111",@"0.00001",nil]];
//                    //水分
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.03",@"0.014",@"0.0101",@"0.0071",@"0.000001", nil]];
//                }
//                break;
//                case 1:
//                {
//                    //美白
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"68",@"160.4",@"323",@"345.2",@"376", nil]];
//                    //均匀度
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"4.0",@"2.48",@"2.22",@"1.57",@"0.92",@"0.66",@"0.4", nil]];
//                    //细纹
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.4",@"0.28",@"0.095",@"0.04",@"0.00001",nil]];
//                    //毛孔
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.2",@"0.14",@"0.09",@"0.04",@"0.02",@"0.00001", nil]];
//                    //色斑
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.6",@"0.42",@"0.27",@"0.233",@"0.111",@"0.00001",nil]];
//                    //水分
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.03",@"0.0135",@"0.0095",@"0.0069",@"0.000001", nil]];
//                }
//                break;
//                case 2:
//                {
//                    //美白 ok
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"68",@"250.4",@"361.65",@"393",@"431", nil]];
//                    //均匀度
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"4.0",@"2.48",@"2.22",@"1.57",@"0.92",@"0.66",@"0.4", nil]];
//                    //细纹 ok
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.4",@"0.28",@"0.08",@"0.035",@"0.00001",nil]];
//                    //毛孔  ok
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.2",@"0.14",@"0.09",@"0.03",@"0.015",@"0.00001", nil]];
//                    //色斑
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.6",@"0.42",@"0.27",@"0.233",@"0.111",@"0.00001",nil]];
//                    //水分  ok
//                    [scoreValueArr addObject:[NSMutableArray arrayWithObjects:@"0.03",@"0.091",@"0.0071",@"0.0056",@"0.000001", nil]];
//                }
//                break;
//                default:
//                {
//                }
//                break;
//            }
//            [scoreLevelArr addObject:[NSMutableArray arrayWithObjects:@"0",@"6",@"7.5",@"9",@"10", nil]];
//            [scoreLevelArr addObject:[NSMutableArray arrayWithObjects:@"0",@"5",@"6",@"7",@"8",@"9",@"10", nil]];
//            [scoreLevelArr addObject:[NSMutableArray arrayWithObjects:@"0",@"6",@"7.5",@"9",@"10",nil]];
//            [scoreLevelArr addObject:[NSMutableArray arrayWithObjects:@"0",@"6",@"7",@"8",@"9",@"10", nil]];
//            [scoreLevelArr addObject:[NSMutableArray arrayWithObjects:@"0",@"6",@"7",@"8",@"9",@"10", nil]];
//            [scoreLevelArr addObject:[NSMutableArray arrayWithObjects:@"0",@"6.0",@"7.0",@"8.5",@"10", nil]];
//            [_ScoreStandard InitializeValue:scoreValueArr levelArr:scoreLevelArr];
//            [standardArr addObject:_ScoreStandard];
//        }
//    }
//        return self;
//    }
//    -(ScoreStandard*) computeStandard:(float) brightness
//    {
//        float rangeK = 0;
//        for (NSInteger i = 0; i<brightnessN; ++i) {
//            if (i == brightnessN-1) {
//                rangeK = [[brightnessArr objectAtIndex:brightnessN-1]floatValue];
//                break;
//            }
//            float brightnessi = [[brightnessArr objectAtIndex:i]floatValue];
//            float brightnessj = [[brightnessArr objectAtIndex:i+1]floatValue];
//            if (brightness >=brightnessi &&brightness < brightnessj) {
//                rangeK = (brightness - brightnessi) / (brightnessj - brightnessi) + i;
//                break;
//            }
//        }
//        if (rangeK>=brightnessN) {
//            return [standardArr objectAtIndex:(brightnessN-1)];
//        }
//        else if(rangeK<=0)
//        {
//            return [standardArr objectAtIndex:0];
//        }
//        ScoreStandard* standardFloor = [standardArr objectAtIndex:floor(rangeK)];
//        ScoreStandard* standarUp = [standardArr objectAtIndex:floor(rangeK)+1];
//        float alpha = rangeK - floor(rangeK);
//        ScoreStandard* newScoreStandard = [[ScoreStandard alloc]init];
//        [newScoreStandard interplate:standardFloor standardUp:standarUp alpha:alpha];
//        return newScoreStandard;
//    }
//}
