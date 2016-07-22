$ = function(el) {
        return document.querySelector(el);
    }
    $$ = function(el) {
        return document.querySelectorAll(el);
    }
    var checkResult = {
        right: false,
        tip: ''
    }
    var inputEles = [$('#add-num'), $('#add-name'), $('#add-phone'), $('#add-time')];
    var originTip = ['长度为3-10个字符', '输入2到16位的中文', '请输入11位电话号码','请输入成立日期'];
    function checkValue(ele) {
        var str = ele.value.trim();
        if (str.length === 0) {
            checkResult.right = false;
            checkResult.tip = '输入不能为空';
            return;
        }
        // 名称
        if (ele === inputEles[0]) {
            var len = str.replace(new RegExp('[^\x00-\xff]', 'g'), 'aa').length;
            if (len >= 3 && len <= 10) {
                checkResult.right = true;
                checkResult.tip = '编号可用';
            } else {
                checkResult.right = false;
                checkResult.tip = '请检查名称字符数';
            }
        }
        if (ele === inputEles[1]) {
            if (str.match(/^[\u4E00-\u9FA5]{2,16}$/)) {
                checkResult.right = true;
                checkResult.tip = '格式正确';
            } else {
                checkResult.right = false;
                checkResult.tip = '请输入2到16位的中文';
            }
        }
        
        if (ele === inputEles[2]) {
            if (str.match(/^1\d{10}$/)) {
                checkResult.right = true;
                checkResult.tip = '号码可用';
            } else {
                checkResult.right = false;
                checkResult.tip = '号码格式错误';
            }
        }
        if (ele === inputEles[3]) {
            if (str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/)) {
                checkResult.right = true;
                checkResult.tip = '格式正确';
            } else {
                checkResult.right = false;
                checkResult.tip = '请输入成立日期';
            }
        }
    }
    for (var i = 0; i < inputEles.length; i++) {
        inputEles[i].addEventListener('blur', function(e) {
            checkValue(e.target);
            var span = e.target.parentElement.getElementsByTagName('span')[0];
            span.innerHTML = checkResult.tip;
            if (checkResult.right) {
                e.target.style.border = '1px solid #53c7a0';
                span.style.color = '#53c7a0';
                span.style.fontSize=8+'px';
            } else {
                e.target.style.border = '1px solid #e8614b';
                span.style.color = '#e8614b';
            }
        })
        inputEles[i].addEventListener('focus', function(e) {
            var index = inputEles.indexOf(e.target);
            var span = e.target.parentElement.getElementsByTagName('span')[0];
            span.innerHTML = originTip[index];
            span.style.visibility = 'visible';
            span.style.color = 'gray';
            span.style.fontSize=8+'px';
        })
    }
    $('#check').addEventListener('click', function(e) {
        var right = true;
        for (var i = 0; i < inputEles.length; i++) {
            var input = inputEles[i];
            checkValue(input);
            var span = input.parentElement.getElementsByTagName('span')[0];
            span.style.visibility = 'visible';
            span.innerHTML = checkResult.tip;
            if (checkResult.right) {
                input.style.border = '1px solid #53c7a0';
                span.style.color = '#53c7a0';
                span.style.fontSize=8+'px';
            } else {
                input.style.border = '1px solid red';
                span.style.color = 'red';
                span.style.fontSize=8+'px';
                right = false;
            }
        }
        if (right) {
            alert('创建成功');
        } else {
            alert('提交失败，请检查输入');
        }
    })

