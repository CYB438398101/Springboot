var CFG = {};
CFG.HOST = {
    RULE: 'http://10.238.255.101:30386',
    WARNING: 'http://10.238.255.101:30094',
    CALENDAR: 'http://10.238.255.101:32598',
    VIDEO:'http://10.80.0.184/video/',
    ZT:'http://10.80.0.184/gylc/',
    PHD:'http://10.80.0.184/phdsssj/',
    TYYH:'http://10.80.0.184/hr/'
};

CFG.TEST_URL = {
    RULE: [
        CFG.HOST.RULE + '/apps',
        CFG.HOST.RULE + '/apps/AS',
        CFG.HOST.RULE + '/apps/AS/rules'
    ],
    WARNING: [
        CFG.HOST.WARNING+'/ForcastService/apps',
        CFG.HOST.WARNING+'/ForcastService/apps/ICT',
        CFG.HOST.WARNING+'/ForcastService/apps/ICT/agents/2222333444'

    ],
    CALENDAR: [

        CFG.HOST.CALENDAR + '/shiftareas',
        CFG.HOST.CALENDAR+'/shiftareas/_shiftAreaxie',
        CFG.HOST.CALENDAR + '/shiftareas/11491'
    ],
    VIDEO:[
        CFG.HOST.VIDEO+'getCameraUrl',
        CFG.HOST.VIDEO+'getCqcJhcCaseCamera',
        CFG.HOST.VIDEO+'getJdCamera',
        CFG.HOST.VIDEO+'getOldCameras',
        CFG.HOST.VIDEO+'getOrg',
        CFG.HOST.VIDEO+'getRtml/2371'
    ],
    ZT:[
        CFG.HOST.ZT+'org/findAll',
        CFG.HOST.ZT+'org/getJqz',
        CFG.HOST.ZT+'org/getCqq',
        CFG.HOST.ZT+'org/getFs',
        CFG.HOST.ZT+'org/getJh',
        CFG.HOST.ZT+'org/getPqz'
    ],
    PHD:[
        CFG.HOST.PHD+'getCqcAll',
        CFG.HOST.PHD,
        CFG.HOST.PHD,

    ],
    TYYH:[
        CFG.HOST.TYYH+'zzjg/getAll',
        CFG.HOST.TYYH+'zzjg/getRoot',
        CFG.HOST.TYYH+'zzjg/getZzjgByParentBH/713',
        CFG.HOST.TYYH+'ryxx/getAll'

    ]
};

CFG.SERVER='http://localhost:8080/testAPI'