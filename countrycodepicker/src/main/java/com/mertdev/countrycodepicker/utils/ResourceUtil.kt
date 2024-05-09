package com.mertdev.countrycodepicker.utils

import com.mertdev.countrycodepicker.R

object ResourceUtil {
    private val imageResourceMap = mapOf(
        "ad.png" to R.drawable.ad,
        "ae.png" to R.drawable.ae,
        "af.png" to R.drawable.af,
        "ag.png" to R.drawable.ag,
        "ai.png" to R.drawable.ai,
        "al.png" to R.drawable.al,
        "am.png" to R.drawable.am,
        "ao.png" to R.drawable.ao,
        "aq.png" to R.drawable.aq,
        "ar.png" to R.drawable.ar,
        "as.png" to R.drawable.`as`,
        "at.png" to R.drawable.at,
        "au.png" to R.drawable.au,
        "aw.png" to R.drawable.aw,
        "ax.png" to R.drawable.ax,
        "az.png" to R.drawable.az,
        "ba.png" to R.drawable.ba,
        "bb.png" to R.drawable.bb,
        "bd.png" to R.drawable.bd,
        "be.png" to R.drawable.be,
        "bf.png" to R.drawable.bf,
        "bg.png" to R.drawable.bg,
        "bh.png" to R.drawable.bh,
        "bi.png" to R.drawable.bi,
        "bj.png" to R.drawable.bj,
        "bl.png" to R.drawable.bl,
        "bm.png" to R.drawable.bm,
        "bn.png" to R.drawable.bn,
        "bo.png" to R.drawable.bo,
        "br.png" to R.drawable.br,
        "bs.png" to R.drawable.bs,
        "bt.png" to R.drawable.bt,
        "bw.png" to R.drawable.bw,
        "by.png" to R.drawable.by,
        "bz.png" to R.drawable.bz,
        "ca.png" to R.drawable.ca,
        "cc.png" to R.drawable.cc,
        "cd.png" to R.drawable.cd,
        "cf.png" to R.drawable.cf,
        "cg.png" to R.drawable.cg,
        "ch.png" to R.drawable.ch,
        "ci.png" to R.drawable.ci,
        "ck.png" to R.drawable.ck,
        "cl.png" to R.drawable.cl,
        "cm.png" to R.drawable.cm,
        "cn.png" to R.drawable.cn,
        "co.png" to R.drawable.co,
        "cr.png" to R.drawable.cr,
        "cu.png" to R.drawable.cu,
        "cv.png" to R.drawable.cv,
        "cx.png" to R.drawable.cx,
        "cy.png" to R.drawable.cy,
        "cz.png" to R.drawable.cz,
        "de.png" to R.drawable.de,
        "dj.png" to R.drawable.dj,
        "dk.png" to R.drawable.dk,
        "dm.png" to R.drawable.dm,
        "do.png" to R.drawable.ic_do,
        "dz.png" to R.drawable.dz,
        "ec.png" to R.drawable.ec,
        "ee.png" to R.drawable.ee,
        "eg.png" to R.drawable.eg,
        "er.png" to R.drawable.er,
        "es.png" to R.drawable.es,
        "et.png" to R.drawable.et,
        "fi.png" to R.drawable.fi,
        "fj.png" to R.drawable.fj,
        "fk.png" to R.drawable.fk,
        "fm.png" to R.drawable.fm,
        "fo.png" to R.drawable.fo,
        "fr.png" to R.drawable.fr,
        "ga.png" to R.drawable.ga,
        "gb.png" to R.drawable.gb,
        "gd.png" to R.drawable.gd,
        "ge.png" to R.drawable.ge,
        "gf.png" to R.drawable.gf,
        "gg.png" to R.drawable.gg,
        "gh.png" to R.drawable.gh,
        "gi.png" to R.drawable.gi,
        "gl.png" to R.drawable.gl,
        "gm.png" to R.drawable.gm,
        "gn.png" to R.drawable.gn,
        "gp.png" to R.drawable.gp,
        "gq.png" to R.drawable.gq,
        "gr.png" to R.drawable.gr,
        "gs.png" to R.drawable.gs,
        "gt.png" to R.drawable.gt,
        "gu.png" to R.drawable.gu,
        "gw.png" to R.drawable.gw,
        "gy.png" to R.drawable.gy,
        "hk.png" to R.drawable.hk,
        "hn.png" to R.drawable.hn,
        "hr.png" to R.drawable.hr,
        "ht.png" to R.drawable.ht,
        "hu.png" to R.drawable.hu,
        "id.png" to R.drawable.id,
        "ie.png" to R.drawable.ie,
        "il.png" to R.drawable.il,
        "im.png" to R.drawable.im,
        "in.png" to R.drawable.`in`,
        "io.png" to R.drawable.io,
        "iq.png" to R.drawable.iq,
        "ir.png" to R.drawable.ir,
        "is.png" to R.drawable.`is`,
        "it.png" to R.drawable.it,
        "je.png" to R.drawable.je,
        "jm.png" to R.drawable.jm,
        "jo.png" to R.drawable.jo,
        "jp.png" to R.drawable.jp,
        "ke.png" to R.drawable.ke,
        "kg.png" to R.drawable.kg,
        "kh.png" to R.drawable.kh,
        "ki.png" to R.drawable.ki,
        "km.png" to R.drawable.km,
        "kn.png" to R.drawable.kn,
        "kp.png" to R.drawable.kp,
        "kr.png" to R.drawable.kr,
        "kw.png" to R.drawable.kw,
        "ky.png" to R.drawable.ky,
        "kz.png" to R.drawable.kz,
        "la.png" to R.drawable.la,
        "lb.png" to R.drawable.lb,
        "lc.png" to R.drawable.lc,
        "li.png" to R.drawable.li,
        "lk.png" to R.drawable.lk,
        "lr.png" to R.drawable.lr,
        "ls.png" to R.drawable.ls,
        "lt.png" to R.drawable.lt,
        "lu.png" to R.drawable.lu,
        "lv.png" to R.drawable.lv,
        "ly.png" to R.drawable.ly,
        "ma.png" to R.drawable.ma,
        "mc.png" to R.drawable.mc,
        "md.png" to R.drawable.md,
        "me.png" to R.drawable.me,
        "mf.png" to R.drawable.mf,
        "mg.png" to R.drawable.mg,
        "mh.png" to R.drawable.mh,
        "mk.png" to R.drawable.mk,
        "ml.png" to R.drawable.ml,
        "mm.png" to R.drawable.mm,
        "mn.png" to R.drawable.mn,
        "mo.png" to R.drawable.mo,
        "mp.png" to R.drawable.mp,
        "mq.png" to R.drawable.mq,
        "mr.png" to R.drawable.mr,
        "ms.png" to R.drawable.ms,
        "mt.png" to R.drawable.mt,
        "mu.png" to R.drawable.mu,
        "mv.png" to R.drawable.mv,
        "mw.png" to R.drawable.mw,
        "mx.png" to R.drawable.mx,
        "my.png" to R.drawable.my,
        "mz.png" to R.drawable.mz,
        "na.png" to R.drawable.na,
        "nc.png" to R.drawable.nc,
        "ne.png" to R.drawable.ne,
        "nf.png" to R.drawable.nf,
        "ng.png" to R.drawable.ng,
        "ni.png" to R.drawable.ni,
        "nl.png" to R.drawable.nl,
        "no.png" to R.drawable.no,
        "np.png" to R.drawable.np,
        "nr.png" to R.drawable.nr,
        "nu.png" to R.drawable.nu,
        "nz.png" to R.drawable.nz,
        "om.png" to R.drawable.om,
        "pa.png" to R.drawable.pa,
        "pe.png" to R.drawable.pe,
        "pf.png" to R.drawable.pf,
        "pg.png" to R.drawable.pg,
        "ph.png" to R.drawable.ph,
        "pk.png" to R.drawable.pk,
        "pl.png" to R.drawable.pl,
        "pm.png" to R.drawable.pm,
        "pn.png" to R.drawable.pn,
        "pr.png" to R.drawable.pr,
        "ps.png" to R.drawable.ps,
        "pt.png" to R.drawable.pt,
        "pw.png" to R.drawable.pw,
        "py.png" to R.drawable.py,
        "qa.png" to R.drawable.qa,
        "re.png" to R.drawable.re,
        "ro.png" to R.drawable.ro,
        "rs.png" to R.drawable.rs,
        "ru.png" to R.drawable.ru,
        "rw.png" to R.drawable.rw,
        "sa.png" to R.drawable.sa,
        "sb.png" to R.drawable.sb,
        "sc.png" to R.drawable.sc,
        "sd.png" to R.drawable.sd,
        "se.png" to R.drawable.se,
        "sg.png" to R.drawable.sg,
        "sh.png" to R.drawable.sh,
        "si.png" to R.drawable.si,
        "sj.png" to R.drawable.sj,
        "sk.png" to R.drawable.sk,
        "sl.png" to R.drawable.sl,
        "sm.png" to R.drawable.sm,
        "sn.png" to R.drawable.sn,
        "so.png" to R.drawable.so,
        "sr.png" to R.drawable.sr,
        "ss.png" to R.drawable.ss,
        "st.png" to R.drawable.st,
        "sv.png" to R.drawable.sv,
        "sx.png" to R.drawable.sx,
        "sy.png" to R.drawable.sy,
        "sz.png" to R.drawable.sz,
        "ta.png" to R.drawable.ta,
        "tc.png" to R.drawable.tc,
        "td.png" to R.drawable.td,
        "tf.png" to R.drawable.tf,
        "tg.png" to R.drawable.tg,
        "th.png" to R.drawable.th,
        "tj.png" to R.drawable.tj,
        "tk.png" to R.drawable.tk,
        "tl.png" to R.drawable.tl,
        "tm.png" to R.drawable.tm,
        "tn.png" to R.drawable.tn,
        "to.png" to R.drawable.to,
        "tr.png" to R.drawable.tr,
        "tt.png" to R.drawable.tt,
        "tv.png" to R.drawable.tv,
        "tw.png" to R.drawable.tw,
        "tz.png" to R.drawable.tz,
        "ua.png" to R.drawable.ua,
        "ug.png" to R.drawable.ug,
        "um.png" to R.drawable.um,
        "us.png" to R.drawable.us,
        "uy.png" to R.drawable.uy,
        "uz.png" to R.drawable.uz,
        "va.png" to R.drawable.va,
        "vc.png" to R.drawable.vc,
        "ve.png" to R.drawable.ve,
        "vg.png" to R.drawable.vg,
        "vi.png" to R.drawable.vi,
        "vn.png" to R.drawable.vn,
        "vu.png" to R.drawable.vu,
        "wf.png" to R.drawable.wf,
        "ws.png" to R.drawable.ws,
        "xk.png" to R.drawable.xk,
        "ye.png" to R.drawable.ye,
        "yt.png" to R.drawable.yt,
        "za.png" to R.drawable.za,
        "zm.png" to R.drawable.zm,
        "zw.png" to R.drawable.zw
    )

    fun getImageResource(imageName: String): Int {
        return imageResourceMap[imageName]!!
    }
}